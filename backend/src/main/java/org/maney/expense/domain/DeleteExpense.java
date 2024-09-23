package org.maney.expense.domain;

public class DeleteExpense {
	private final ExpenseRepository expenseRepository;

	DeleteExpense(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public void execute(int ownerId, int expenseId) {
		expenseRepository.deleteExpenseForUser(ownerId, expenseId);
	}
}
