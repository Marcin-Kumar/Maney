package org.maney.expense.domain;

import java.util.List;

public interface ExpenseRepository {
	List<Expense> getAllExpensesForUser(int ownerId);

	void addExpenseForUser(int ownerId, Expense expense);

	void deleteExpenseForUser(int ownerId, int expenseId);

	void modifyExpense(int ownerId, Expense expense);
}
