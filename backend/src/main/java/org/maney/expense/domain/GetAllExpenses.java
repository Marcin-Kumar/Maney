package org.maney.expense.domain;


public class GetAllExpenses {
	private final ExpenseRepository expenseRepository;
	private final ExpensePresenter expensePresenter;

	GetAllExpenses(ExpenseRepository expenseRepository, ExpensePresenter expensePresenter) {
		this.expenseRepository = expenseRepository;
		this.expensePresenter = expensePresenter;
	}

	public void execute(int ownerId) {
		try {
			var expenses = expenseRepository.getAllExpensesForUser(ownerId);
			expensePresenter.presentAllExpensesForUser(expenses);
		} catch (UserNotFoundException e) {
			expensePresenter.presentUserNotFound();
		}
	}
}
