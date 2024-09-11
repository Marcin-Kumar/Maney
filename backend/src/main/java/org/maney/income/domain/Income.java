package org.maney.income.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class Income {
    BigDecimal amount;
    IncomeCategory category;
    Currency currency;
    String ownerId;
    Date timestamp;

    public Income(BigDecimal amount, Currency currency, String ownerId) {
        this.amount = amount.compareTo(BigDecimal.ZERO) < 0
                ? amount.abs()
                : amount;
        this.currency = currency;
        this.ownerId = ownerId;
        this.timestamp = new Date();
        this.category = new IncomeCategory("UNCATEGORIZED");
    }

    public Income(BigDecimal amount, Currency currency, IncomeCategory category,  String ownerId) {
        this.amount = amount.compareTo(BigDecimal.ZERO) < 0
                ? amount.abs()
                : amount;
        this.currency = currency;
        this.ownerId = ownerId;
        this.timestamp = new Date();
        this.category = category;
    }

    @Override
    public String toString() {
        return this.amount
                + " "
                + this.currency.getSymbol();
    }
}