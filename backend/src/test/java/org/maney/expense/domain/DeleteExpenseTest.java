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
		deleteExpense = new DeleteExpense(mockExpenseRepository);
	}

	@Test
	void deleteExpenseFromUserBalanceSheet() {
		deleteExpense.execute(1, 1);
		verify(mockExpenseRepository, times(1)).deleteExpenseForUser(anyInt(), anyInt());
	}
}