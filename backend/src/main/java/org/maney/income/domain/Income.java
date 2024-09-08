package org.maney.income.domain;

public class Income {
    private double _amount;
    private final Currency _currency;

    public Income(double _amount, Currency _currency) {
        this._amount = _amount < 0.0
                ? Math.abs(_amount)
                : _amount;
        this._currency = _currency;
    }

    public double get_amount() {
        return _amount;
    }

    public void set_amount(double _amount) {
        this._amount = _amount;
    }

    @Override
    public String toString() {
        return this._amount + this._currency.toString();
    }
}