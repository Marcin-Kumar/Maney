package org.maney.income.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;

public class IncomeEntity implements EntityMapper<IncomeEntity, IncomeModel> {
    BigDecimal amount;
    IncomeCategoryEntity category;
    Currency currency;
    String ownerId;
    Instant timestamp;

    public IncomeEntity(BigDecimal amount, Currency currency, String ownerId) {
        this.amount = amount.compareTo(BigDecimal.ZERO) < 0
                ? amount.abs()
                : amount;
        this.currency = currency;
        this.ownerId = ownerId;
        this.timestamp = Instant.now();
        this.category = new IncomeCategoryEntity("UNCATEGORIZED");
    }

    public IncomeEntity(BigDecimal amount, Currency currency, IncomeCategoryEntity category, String ownerId) {
        this.amount = amount.compareTo(BigDecimal.ZERO) < 0
                ? amount.abs()
                : amount;
        this.currency = currency;
        this.ownerId = ownerId;
        this.timestamp = Instant.now();
        this.category = category;
    }

    @Override
    public String toString() {
        return this.amount
                + " "
                + this.currency.getSymbol();
    }

    @Override
    public IncomeModel toModel(IncomeEntity entity) {
        return null;
    }
}