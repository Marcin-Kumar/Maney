package org.maney.user.domain;

import org.maney.income.domain.IncomeEntity;
import org.maney.expense.domain.Expense;


import java.util.List;

public class User {
    String firstName;
    String lastName;
    List<IncomeEntity> incomeEntityList;
	  List<Expense> expenseList;
}
