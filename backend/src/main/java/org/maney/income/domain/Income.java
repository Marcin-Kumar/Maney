package org.maney.income.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Income {
    BigDecimal amount;
    Currency currency;
    Date timestamp;
    String ownerId;

    public IncomeCategory get_category() {
        return _category;
    }

    private final IncomeCategory _category;

    public Income(BigDecimal amount, Currency currency, String ownerId) {
        this.amount = amount.compareTo(BigDecimal.ZERO) < 0
                ? amount.abs()
                : amount;
        this.currency = currency;
        this.ownerId = ownerId;
        this.timestamp = new Date();
        this._category = new IncomeCategory("UNCATEGORIZED");
    }

    public Income(BigDecimal amount, Currency currency, IncomeCategory category,  String ownerId) {
        this.amount = amount.compareTo(BigDecimal.ZERO) < 0
                ? amount.abs()
                : amount;
        this.currency = currency;
        this.ownerId = ownerId;
        this.timestamp = new Date();
        this._category = category;
    }

    @Override
    public String toString() {
        return this.amount
                + " "
                + this.currency.toString();
    }
}