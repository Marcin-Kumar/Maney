package org.maney.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class AddExpenseTest {
	private AddExpense addExpense;
	private ExpenseRepository mockExpenseRepository;

	@BeforeEach
	void setUp() {
		mockExpenseRepository = mock(ExpenseRepository.class);
		addExpense = new AddExpense(mockExpenseRepository);
	}

	@Test
	void addAnExpenseToUserBalanceSheet() {
		addExpense.execute(1, new Expense(1,
				BigDecimal.valueOf(100.1),
				"Groceries", "Veggies", LocalDateTime.now(), "CHF"));
		verify(mockExpenseRepository, times(1)).addExpenseForUser(anyInt(), any(Expense.class));
	}
}