package org.maney.expense.domain;

public class DeleteExpense {
	private final ExpenseRepository expenseRepository;
	private final ExpensePresenter expensePresenter;

	DeleteExpense(ExpenseRepository expenseRepository, ExpensePresenter expensePresenter) {
		this.expenseRepository = expenseRepository;
		this.expensePresenter = expensePresenter;
	}

	public void execute(int ownerId, int expenseId) {
		try {
			expenseRepository.deleteExpenseForUser(ownerId, expenseId);
			expensePresenter.presentUserExpenseDeleted();
		} catch (UserNotFoundException e) {
			expensePresenter.presentUserNotFound();
		}
	}
}
