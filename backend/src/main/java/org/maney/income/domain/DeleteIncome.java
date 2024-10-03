package org.maney.income.domain;

import org.maney.user.domain.UserRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class DeleteIncome {
    UserRepository userRepository; // income repo port
    IncomeRepository incomeRepository; // income repo port
    IncomePresenter incomePresenter;

    public DeleteIncome(IncomeRepository incomeRepository,
                        UserRepository userRepository,
                        IncomePresenter incomePresenter) {
        this.incomeRepository = incomeRepository;
        this.userRepository = userRepository;
        this.incomePresenter = incomePresenter;
    }

    void invoke(Instant timestamp, String ownerId, BigDecimal amount) {
        if(!userRepository.doesUserExist(ownerId)) {
            String message = String.format("User %s not found", ownerId);
            this.incomePresenter.presentIncomeCannotBeDeleted(message);
            return;
        }

        IncomeModel incomeModel = incomeRepository.findByTimeStampAndOwnerId(timestamp, ownerId);
        if (!Objects.equals(incomeModel.amount, amount)) {
            String message = String.format("Income %s not found", amount);
            this.incomePresenter.presentIncomeCannotBeDeleted(message);
            return;
        }

        this.incomeRepository.delete(incomeModel);
        this.incomePresenter.presentIncomeSuccessfullyDeleted();
    }
}
