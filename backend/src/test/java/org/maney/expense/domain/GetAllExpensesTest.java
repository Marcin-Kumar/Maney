package org.maney.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class GetAllExpensesTest {
	private GetAllExpenses getAllExpenses;
	private ExpenseRepository mockExpenseRepository;
	private ExpensePresenter mockExpensePresenter;

	@BeforeEach
	void setUp() {
		mockExpenseRepository = mock(ExpenseRepository.class);
		mockExpensePresenter = mock(ExpensePresenter.class);
		getAllExpenses = new GetAllExpenses(mockExpenseRepository, mockExpensePresenter);
	}

	@Test
	void getAllExpensesForUser() throws UserNotFoundException {
		when(mockExpenseRepository.getAllExpensesForUser(anyInt())).thenReturn(List.of(new Expense(1,
				BigDecimal.valueOf(100.1),
				"Groceries", "Veggies", LocalDateTime.now(), "CHF")));

		getAllExpenses.execute(1);
		verify(mockExpenseRepository, times(1)).getAllExpensesForUser(anyInt());
		verify(mockExpensePresenter, times(1)).presentAllExpensesForUser(ArgumentMatchers.anyList());
	}


	@Test
	void getAllExpensesForNonExistentUser() throws UserNotFoundException {
		doThrow(UserNotFoundException.class).when(mockExpenseRepository).getAllExpensesForUser(anyInt());

		getAllExpenses.execute(1);
		verify(mockExpenseRepository, times(1)).getAllExpensesForUser(anyInt());
		verify(mockExpensePresenter, times(1)).presentUserNotFound();
	}
}