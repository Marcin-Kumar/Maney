package org.maney.user.domain;

import org.maney.expense.dummyExpenseClass;
import org.maney.income.domain.Income;

import java.util.List;

public class User {
    String firstName;
    String lastName;
    List<Income> incomeList;
    List<dummyExpenseClass> expenseList;
}
