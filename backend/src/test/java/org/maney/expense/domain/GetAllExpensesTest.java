package org.maney.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class GetAllExpensesTest {
	private GetAllExpenses getAllExpenses;
	private ExpenseRepository mockExpenseRepository;

	@BeforeEach
	void setUp() {
		mockExpenseRepository = mock(ExpenseRepository.class);
		getAllExpenses = new GetAllExpenses(mockExpenseRepository);
		when(mockExpenseRepository.getAllExpensesForUser(anyInt())).thenReturn(List.of(new Expense(1,
				BigDecimal.valueOf(100.1),
				"Groceries", "Veggies", LocalDateTime.now(), "CHF")));
	}

	@Test
	void getAllExpensesFromUserBalanceSheet() {
		getAllExpenses.execute(1);
		verify(mockExpenseRepository, times(1)).getAllExpensesForUser(anyInt());
	}
}