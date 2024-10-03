package org.maney.expense.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class DeleteExpenseTest {
	private DeleteExpense deleteExpense;
	private ExpenseRepository mockExpenseRepository;
	private ExpensePresenter mockExpensePresenter;

	@BeforeEach
	void setUp() {
		mockExpenseRepository = mock(ExpenseRepository.class);
		mockExpensePresenter = mock(ExpensePresenter.class);
		deleteExpense = new DeleteExpense(mockExpenseRepository, mockExpensePresenter);
	}

	@Test
	void deleteExpenseForUser() throws UserNotFoundException {
		deleteExpense.execute(1, 1);
		verify(mockExpenseRepository, times(1)).deleteExpenseForUser(anyInt(), anyInt());
		verify(mockExpensePresenter, times(1)).presentUserExpenseDeleted();
	}

	@Test
	void deleteExpenseForNonExistentUser() throws UserNotFoundException {
		doThrow(UserNotFoundException.class).when(mockExpenseRepository).deleteExpenseForUser(anyInt(), anyInt());

		deleteExpense.execute(1, 1);

		verify(mockExpenseRepository, times(1)).deleteExpenseForUser(anyInt(), anyInt());
		verify(mockExpensePresenter, times(1)).presentUserNotFound();
	}
}