package org.maney.income.domain;

import java.time.Instant;

public interface IncomeRepository {
    public IncomeModel findByTimeStampAndOwnerId(Instant timestamp, String ownerId);

    public void  save(IncomeModel incomeModel);

    public void  delete(IncomeModel incomeModel);
}
