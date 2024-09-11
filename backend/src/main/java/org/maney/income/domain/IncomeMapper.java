package org.maney.income.domain;

public class IncomeMapper {
    IncomeModel toModel(Income income) {
        return new IncomeModel(
                income.amount,
                income.currency.getCurrencyCode(),
                income.timestamp,
                income.ownerId,
                income.category.name
        );
    }
}
