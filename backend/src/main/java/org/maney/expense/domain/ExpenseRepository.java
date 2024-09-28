package org.maney.expense.domain;

import java.util.List;

public interface ExpenseRepository {
	List<Expense> getAllExpensesForUser(int ownerId) throws UserNotFoundException;

	void addExpenseForUser(int ownerId, Expense expense) throws UserNotFoundException;

	void deleteExpenseForUser(int ownerId, int expenseId) throws UserNotFoundException;

	void modifyExpense(int ownerId, Expense expense) throws UserNotFoundException;
}
