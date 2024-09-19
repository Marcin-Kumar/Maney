package org.maney.income.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

public class IncomeModel {
    BigDecimal amount;
    String categoryName;
    String currencyCode;
    String ownerId;
    Instant timestamp;


    public IncomeModel(BigDecimal amount, String currencyCode, Instant timestamp, String ownerId, String categoryName) {
        this.amount = amount;
        this.categoryName = categoryName;
        this.currencyCode = currencyCode;
        this.ownerId = ownerId;
        this.timestamp = timestamp;
    }
}
