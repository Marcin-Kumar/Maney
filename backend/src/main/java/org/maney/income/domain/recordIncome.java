package org.maney.income.domain;

import java.math.BigDecimal;
import java.util.Currency;

public class recordIncome {
    IncomeRepository incomeRepository; // income repo port
    final String SWISS_FRANC_CURRENCY_CODE = "CHF";

    public recordIncome(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    void invoke(IncomeModel incomeModel) {
        if(BigDecimal.ZERO.equals(incomeModel.amount.abs())) {
            // present ZERO not supported
        }

        // check if category exists in category repo
        // present category not found

        // check if user exists in user repo
        // present user not found


        Currency currency;
        try {
            currency = Currency.getInstance(incomeModel.currency);
        } catch (IllegalArgumentException e) {
            currency = Currency.getInstance(SWISS_FRANC_CURRENCY_CODE);
            // choose default currency from user repo
        }

        // convert into income entity to do some stuff like
        // ... reduce budget
//        incomeRepository.save(incomeModel);
    }
}
