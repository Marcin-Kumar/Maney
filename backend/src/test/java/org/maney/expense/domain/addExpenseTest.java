package org.maney.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class AddExpenseTest {
	private AddExpense addExpense;
	private ExpenseRepository mockExpenseRepository;

	@BeforeEach
	void setUp() {
		mockExpenseRepository = mock(ExpenseRepository.class);
		when(mockExpenseRepository.addExpenseForUser(anyInt())).thenAnswer();
	}

	@Test
	void deleteExpenseToUserBalanceSheet() {
		addExpense.execute();
		verify(mockExpenseRepository).addExpenseForUser(anyInt());
	}
}