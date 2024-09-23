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

	@BeforeEach
	void setUp() {
		mockExpenseRepository = mock(ExpenseRepository.class);
		modifyExpense = new ModifyExpense(mockExpenseRepository);
	}

	@Test
	void EditExpenseFromUserBalanceSheet() {
		modifyExpense.execute(1, new Expense(1,
				BigDecimal.valueOf(100.1),
				"Groceries", "Tomatoes", LocalDateTime.now(), "CHF"));
		verify(mockExpenseRepository).modifyExpense(anyInt(), any(Expense.class));
	}
}