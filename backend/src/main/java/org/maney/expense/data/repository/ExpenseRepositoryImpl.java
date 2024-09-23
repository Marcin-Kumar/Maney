package org.maney.expense.data.repository;

import org.maney.expense.domain.Expense;
import org.maney.expense.domain.ExpenseRepository;

import java.util.List;

public class ExpenseRepositoryImpl implements ExpenseRepository {

	@Override
	public List<Expense> getAllExpensesForUser(int ownerId) {
		return List.of();
	}

	@Override
	public void addExpenseForUser(int ownerId, Expense expense) {

	}

	@Override
	public void deleteExpenseForUser(int ownerId, int expenseId) {

	}

	@Override
	public void modifyExpense(int ownerId, Expense expense) {

	}
}
