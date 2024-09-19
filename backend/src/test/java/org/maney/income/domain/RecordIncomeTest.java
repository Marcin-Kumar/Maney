package org.maney.income.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.maney.user.domain.UserRepository;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.util.MockUtil.resetMock;


public class RecordIncomeTest {
    RecordIncome recordIncome;

    IncomeRepository mockIncomeRepository;
    IncomeCategoryRepository mockIncomeCategoryRepository;
    UserRepository mockUserRepository;
    IncomePresenter mockIncomePresenter;

    @BeforeEach
    public void setup() {
        mockIncomeRepository = mock(IncomeRepository.class);
        mockIncomeCategoryRepository = mock(IncomeCategoryRepository.class);
        mockUserRepository = mock(UserRepository.class);
        mockIncomePresenter = mock(IncomePresenter.class);

        recordIncome = new RecordIncome(
                mockIncomeRepository,
                mockIncomeCategoryRepository,
                mockUserRepository,
                mockIncomePresenter
        );

        final IncomeCategoryModel incomeCategoryModel = new IncomeCategoryModel("name", "description");
        when(mockIncomeCategoryRepository.findByName(anyString())).thenReturn(incomeCategoryModel);
        when(mockUserRepository.doesUserExist(anyString())).thenReturn(true);

    }

    @AfterEach
    public void reset() {
        resetMock(mockIncomeRepository);
        resetMock(mockIncomeCategoryRepository);
        resetMock(mockIncomePresenter);
    }

    @Test
    @DisplayName("should record income when all input is correct")
    void recordIncomeWithCorrectInput() {
        final IncomeModel incomeModel = IncomeTesterUtil.buildIncomeModel(null);

        recordIncome.invoke(incomeModel);

        verify(mockIncomeRepository, times(1))
                .save(any(IncomeModel.class));
    }

    @Test
    @DisplayName("should not record income when user is not found")
    void doNotRecordIncomeWhenUserNotFound() {
        final IncomeModel incomeModel = IncomeTesterUtil.buildIncomeModel(null);
        when(mockUserRepository.doesUserExist(anyString())).thenReturn(false);

        recordIncome.invoke(incomeModel);

        verify(mockIncomeRepository, times(0))
                .save(any(IncomeModel.class));
        verify(mockIncomePresenter, times(1))
                .presentIncomeCannotBeRecorded(anyString());
    }

    @Test
    @DisplayName("should not record income when amount is invalid")
    void doNotRecordIncomeWhenAmountIsInvalid() {
        final IncomeModel incomeModel = IncomeTesterUtil.buildIncomeModel(BigDecimal.valueOf(-10.5));
        when(mockUserRepository.doesUserExist(anyString())).thenReturn(false);

        recordIncome.invoke(incomeModel);

        verify(mockIncomeRepository, times(0))
                .save(any(IncomeModel.class));
        verify(mockIncomePresenter, times(1))
                .presentIncomeCannotBeRecorded(anyString());
    }
}
