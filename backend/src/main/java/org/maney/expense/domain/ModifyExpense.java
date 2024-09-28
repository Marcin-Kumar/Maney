package org.maney.expense.domain;

public class ModifyExpense {
	private final ExpenseRepository expenseRepository;
	private final ExpensePresenter expensePresenter;

	ModifyExpense(ExpenseRepository expenseRepository, ExpensePresenter expensePresenter) {
		this.expenseRepository = expenseRepository;
		this.expensePresenter = expensePresenter;
	}

	public void execute(int ownerId, Expense expense) {
		try {
			expenseRepository.modifyExpense(ownerId, expense);
			expensePresenter.presentUserExpenseModified();
		} catch (UserNotFoundException e) {
			expensePresenter.presentUserNotFound();
		}
	}
}
