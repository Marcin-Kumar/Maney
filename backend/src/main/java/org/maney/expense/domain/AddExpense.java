package org.maney.expense.domain;

public class AddExpense {
	private final ExpenseRepository expenseRepository;

	AddExpense(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public void execute(int ownerId, Expense expense) {
		expenseRepository.addExpenseForUser(ownerId, expense);
	}
}
