package org.maney.expense.domain;

public class UserNotFoundException extends Exception {
	UserNotFoundException(String message) {
		super(message);
	}
}
