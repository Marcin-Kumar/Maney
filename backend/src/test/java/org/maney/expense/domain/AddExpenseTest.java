package org.maney.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class AddExpenseTest {
	private AddExpense addExpense;
	private ExpenseRepository mockExpenseRepository;
	private ExpensePresenter mockExpensePresenter;

	@BeforeEach
	void setUp() {
		mockExpenseRepository = mock(ExpenseRepository.class);
		mockExpensePresenter = mock(ExpensePresenter.class);
		addExpense = new AddExpense(mockExpenseRepository, mockExpensePresenter);
	}

	@Test
	void addExpenseForUser() throws UserNotFoundException {
		addExpense.execute(1, new Expense(1,
				BigDecimal.valueOf(100.1),
				"Groceries", "Veggies", LocalDateTime.now(), "CHF"));
		verify(mockExpenseRepository, times(1)).addExpenseForUser(anyInt(), any(Expense.class));
		verify(mockExpensePresenter, times(1)).presentUserExpenseAdded();
	}


	@Test
	void addExpenseForNonExistentUser() throws UserNotFoundException {
		doThrow(UserNotFoundException.class).when(mockExpenseRepository).addExpenseForUser(anyInt(),
				any(Expense.class));

		addExpense.execute(1, new Expense(1,
				BigDecimal.valueOf(100.1),
				"Groceries", "Veggies", LocalDateTime.now(), "CHF"));
		verify(mockExpenseRepository, times(1)).addExpenseForUser(anyInt(), any(Expense.class));
		verify(mockExpensePresenter, times(1)).presentUserNotFound();
	}
}