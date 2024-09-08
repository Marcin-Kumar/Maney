package org.maney.user.domain;

import org.maney.expense.dummyExpenseClass;
import org.maney.income.dummyIncomeClass;

import java.util.List;

public class User {
    String firstName;
    String lastName;
    List<dummyIncomeClass> incomeList;
    List<dummyExpenseClass> expenseList;
}
