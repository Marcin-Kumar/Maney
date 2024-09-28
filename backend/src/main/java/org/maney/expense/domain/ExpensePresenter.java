package org.maney.expense.domain;

import java.util.List;

public interface ExpensePresenter {
	void presentUserNotFound();

	void presentAllExpensesForUser(List<Expense> expenses);

	void presentUserExpenseAdded();

	void presentUserExpenseDeleted();

	void presentUserExpenseModified();
}
