package org.maney.income.domain;

public class IncomeEntityMapper implements  EntityMapper<IncomeEntity, IncomeModel> {

    @Override
    public IncomeModel toModel(IncomeEntity entity) {
        return new IncomeModel(
                entity.amount,
                entity.currency.getCurrencyCode(),
                entity.timestamp,
                entity.ownerId,
                entity.category.name
        );
    }
}
