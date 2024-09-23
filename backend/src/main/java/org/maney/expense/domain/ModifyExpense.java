package org.maney.expense.domain;

public class ModifyExpense {
	private final ExpenseRepository expenseRepository;

	ModifyExpense(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public void execute(int ownerId, Expense expense) {
		expenseRepository.modifyExpense(ownerId, expense);
	}
}
