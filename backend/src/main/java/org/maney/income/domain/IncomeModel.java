package org.maney.income.domain;

import java.math.BigDecimal;
import java.util.Date;

public class IncomeModel {
    BigDecimal amount;
    String category;
    String currency;
    String ownerId;
    Date timestamp;


    public IncomeModel(BigDecimal amount, String currency, Date timestamp, String ownerId, String category) {
        this.amount = amount;
        this.category = category;
        this.currency = currency;
        this.ownerId = ownerId;
        this.timestamp = timestamp;
    }
}
