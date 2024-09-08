package org.maney.income.domain;

import java.util.Date;

public class Income {
    private final double _amount;
    private final Currency _currency;
    private final Date _timestamp;
    private final String _ownerId;

    public IncomeCategory get_category() {
        return _category;
    }

    private final IncomeCategory _category;

    public Income(double amount, Currency currency, String ownerId) {
        this._amount = amount < 0.0
                ? Math.abs(amount)
                : amount;
        this._currency = currency;
        _ownerId = ownerId;
        this._timestamp = new Date();
        this._category = new IncomeCategory("UNCATEGORIZED");
    }

    public Income(double amount, Currency currency, IncomeCategory category,  String ownerId) {
        this._amount = amount < 0.0
                ? Math.abs(amount)
                : amount;
        this._currency = currency;
        _ownerId = ownerId;
        this._timestamp = new Date();
        this._category = category;
    }

    public double get_amount() {
        return _amount;
    }

    @Override
    public String toString() {
        return this._amount
                + " "
                + this._currency.toString();
    }
}