package org.maney.expense.domain;


public class GetAllExpenses {
	private final ExpenseRepository expenseRepository;

	GetAllExpenses(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public void execute(int ownerId) {
		var expenses = expenseRepository.getAllExpensesForUser(ownerId);
	}
}
