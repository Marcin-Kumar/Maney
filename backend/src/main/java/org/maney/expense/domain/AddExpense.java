package org.maney.expense.domain;

public class AddExpense {
	private final ExpenseRepository expenseRepository;
	private final ExpensePresenter expensePresenter;

	AddExpense(ExpenseRepository expenseRepository, ExpensePresenter expensePresenter) {
		this.expenseRepository = expenseRepository;
		this.expensePresenter = expensePresenter;
	}

	public void execute(int ownerId, Expense expense) {
		try {
			expenseRepository.addExpenseForUser(ownerId, expense);
			expensePresenter.presentUserExpenseAdded();
		} catch (UserNotFoundException e) {
			expensePresenter.presentUserNotFound();
		}
	}
}
