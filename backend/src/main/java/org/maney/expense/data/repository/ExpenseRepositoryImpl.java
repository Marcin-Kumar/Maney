package org.maney.expense.data.repository;

import org.maney.expense.domain.Expense;
import org.maney.expense.domain.ExpenseRepository;
import org.maney.expense.domain.UserNotFoundException;

import java.util.List;

public class ExpenseRepositoryImpl implements ExpenseRepository {

	@Override
	public List<Expense> getAllExpensesForUser(int ownerId) throws UserNotFoundException {
		return List.of();
	}

	@Override
	public void addExpenseForUser(int ownerId, Expense expense) throws UserNotFoundException {
		// wIP
	}

	@Override
	public void deleteExpenseForUser(int ownerId, int expenseId) throws UserNotFoundException {
		// wIP
	}

	@Override
	public void modifyExpense(int ownerId, Expense expense) throws UserNotFoundException {
		// wIP
	}
}
