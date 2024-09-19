package org.maney.income.domain;

import java.math.BigDecimal;
import java.util.Currency;

public class RecordIncome {
    private final IncomeEntityMapper incomeEntityMapper;
    IncomeCategoryRepository incomeCategoryRepository; // income repo port
    IncomeRepository incomeRepository; // income repo port
    IncomePresenter incomePresenter; // income presenter port
    final String SWISS_FRANC_CURRENCY_CODE = "CHF";

    public RecordIncome(IncomeRepository incomeRepository,
                        IncomeCategoryRepository incomeCategoryRepository,
                        IncomePresenter incomePresenter) {
        this.incomeCategoryRepository = incomeCategoryRepository;
        this.incomeRepository = incomeRepository;
        this.incomePresenter = incomePresenter;

        incomeEntityMapper = new IncomeEntityMapper();
    }

    void invoke(IncomeModel incomeModel) {
        if (BigDecimal.ZERO.equals(incomeModel.amount.abs())) {
            String message = String.format("IncomeEntity with amount %s cannot be recorded", incomeModel.amount);
            this.incomePresenter.incomeCannotBeRecorded(message);
        }

        IncomeCategoryModel incomeCategoryModel = incomeCategoryRepository.findByName(incomeModel.categoryName);
        if (incomeCategoryModel==null) {
            incomeCategoryModel = new IncomeCategoryModel(incomeModel.categoryName);
            this.incomeCategoryRepository.create(incomeCategoryModel);
        }

        // check if user exists in user repo
        // present user not found

        Currency currency;
        try {
            currency = Currency.getInstance(incomeModel.currencyCode);
        } catch (IllegalArgumentException e) {
            currency = Currency.getInstance(SWISS_FRANC_CURRENCY_CODE);
            // choose default currency from user repo
        }

        final IncomeEntity incomeEntity = new IncomeEntity(
                incomeModel.amount,
                currency,
                incomeModel.ownerId
        );

        // convert into income entity to do some stuff like
        // ... reduce budget

    incomeRepository.save(incomeEntityMapper.toModel(incomeEntity));
    }
}
