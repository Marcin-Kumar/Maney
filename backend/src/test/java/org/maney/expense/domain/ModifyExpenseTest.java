package org.maney.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class ModifyExpenseTest {
	private ModifyExpense modifyExpense;
	private ExpenseRepository mockExpenseRepository;
	private ExpensePresenter mockExpensePresenter;

	@BeforeEach
	void setUp() {
		mockExpenseRepository = mock(ExpenseRepository.class);
		mockExpensePresenter = mock(ExpensePresenter.class);
		modifyExpense = new ModifyExpense(mockExpenseRepository, mockExpensePresenter);
	}

	@Test
	void modifyExpenseForUser() throws UserNotFoundException {
		modifyExpense.execute(1, new Expense(1,
				BigDecimal.valueOf(100.1),
				"Groceries", "Tomatoes", LocalDateTime.now(), "CHF"));
		verify(mockExpenseRepository).modifyExpense(anyInt(), any(Expense.class));
		verify(mockExpensePresenter).presentUserExpenseModified();
	}

	@Test
	void modifyExpenseForNonExistentUser() throws UserNotFoundException {
		doThrow(UserNotFoundException.class).when(mockExpenseRepository).modifyExpense(anyInt(), any(Expense.class));

		modifyExpense.execute(1, new Expense(1,
				BigDecimal.valueOf(100.1),
				"Groceries", "Tomatoes", LocalDateTime.now(), "CHF"));

		verify(mockExpenseRepository, times(1)).modifyExpense(anyInt(), any(Expense.class));
		verify(mockExpensePresenter, times(1)).presentUserNotFound();
	}
}