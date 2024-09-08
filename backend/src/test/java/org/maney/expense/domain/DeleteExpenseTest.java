package org.maney.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class DeleteExpenseTest {
	private DeleteExpense deleteExpense;
	private ExpenseRepository mockExpenseRepository;

	@BeforeEach
	void setUp() {
		mockExpenseRepository = mock(ExpenseRepository.class);
		when(mockExpenseRepository.deleteExpenseForUser(anyInt(), anyInt())).thenAnswer();
	}

	@Test
	void deleteExpenseFromUserBalanceSheet() {
		deleteExpense.execute();
		verify(mockExpenseRepository).deleteExpenseForUser(anyInt(), anyInt());
	}
}