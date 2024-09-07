package org.maney.expense.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Expense {
    int id;
    BigDecimal amount;
    String category;
    String description;
    LocalDateTime dateTime;
    String currency;

    public Expense(int id, BigDecimal amount, String category, String description, LocalDateTime dateTime, String currency) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.dateTime = dateTime;
        this.currency = currency;
    }
}
