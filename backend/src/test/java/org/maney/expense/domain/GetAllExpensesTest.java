package org.maney.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class GetAllExpensesTest {
	private GetAllExpenses getAllExpenses;
	private ExpenseRepository mockExpenseRepository;

	@BeforeEach
	void setUp() {
		mockExpenseRepository = mock(ExpenseRepository.class);
		when(mockExpenseRepository.getAllExpensesForUser(anyInt())).thenAnswer();
	}

	@Test
	void getAllExpensesFromUserBalanceSheet() {
		getAllExpenses.execute();
		verify(mockExpenseRepository).getAllExpensesForUser(anyInt());
	}
}