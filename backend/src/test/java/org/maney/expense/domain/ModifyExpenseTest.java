package org.maney.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class ModifyExpenseTest {
	private ModifyExpense modifyExpense;
	private ExpenseRepository mockExpenseRepository;

	@BeforeEach
	void setUp() {
		mockExpenseRepository = mock(ExpenseRepository.class);
		when(mockExpenseRepository.editExpenseForUser(anyInt(), anyInt())).thenAnswer();
	}

	@Test
	void EditExpenseFromUserBalanceSheet() {
		modifyExpense.execute();
		verify(mockExpenseRepository).editExpenseForUser(anyInt(), anyInt());
	}
}