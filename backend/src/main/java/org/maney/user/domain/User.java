package org.maney.user.domain;

import org.maney.expense.dummyExpenseClass;
import org.maney.income.domain.IncomeEntity;

import java.util.List;

public class User {
    String firstName;
    String lastName;
    List<IncomeEntity> incomeEntityList;
    List<dummyExpenseClass> expenseList;
}
