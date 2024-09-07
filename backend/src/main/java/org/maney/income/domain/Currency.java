package org.maney.income.domain;

public enum Currency {
    SWISS_FRANK("CHF");

    private final String _symbol;

    Currency(String symbol) {
        _symbol = symbol;
    }

    @Override
    public String toString() {
        return this._symbol;
    }
}
