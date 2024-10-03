package org.maney.income.domain;

public class IncomeMapper {
    IncomeModel toModel(IncomeEntity incomeEntity) {
        return new IncomeModel(
                incomeEntity.amount,
                incomeEntity.currency.getCurrencyCode(),
                incomeEntity.timestamp,
                incomeEntity.ownerId,
                incomeEntity.category.name
        );
    }
}
