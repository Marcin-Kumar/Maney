package org.maney.income.domain;

public interface IncomePresenter {

    void presentIncomeCannotBeRecorded(String message);

    void presentIncomeCannotBeDeleted(String message);

    void presentIncomeSuccessfullyDeleted();
}
