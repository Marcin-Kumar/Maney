package org.maney.income.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.maney.user.domain.UserRepository;

import java.math.BigDecimal;
import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.internal.util.MockUtil.resetMock;

public class DeleteIncomeTest {
    DeleteIncome deleteIncome;

    IncomeRepository mockIncomeRepository;
    UserRepository mockUserRepository;
    IncomePresenter mockIncomePresenter;

    @BeforeEach
    public void setup() {
        mockIncomeRepository = mock(IncomeRepository.class);
        mockUserRepository = mock(UserRepository.class);
        mockIncomePresenter = mock(IncomePresenter.class);

        deleteIncome = new DeleteIncome(
                mockIncomeRepository,
                mockUserRepository,
                mockIncomePresenter
        );

        when(mockUserRepository.doesUserExist(anyString())).thenReturn(true);
    }

    @AfterEach
    public void reset() {
        resetMock(mockIncomeRepository);
        resetMock(mockUserRepository);
        resetMock(mockIncomePresenter);
    }

    @Test
    @DisplayName("should delete income when income is found")
    void deleteIncomeWhenFound() {
        final Instant timestamp = Instant.ofEpochSecond(122);
        final IncomeModel incomeModel = IncomeTesterUtil.buildIncomeModel(BigDecimal.valueOf(100));
        when(mockIncomeRepository.findByTimeStampAndOwnerId(any(), anyString())).thenReturn(incomeModel);

        deleteIncome.invoke(timestamp, "manuel", BigDecimal.valueOf(100));

        verify(mockIncomeRepository, times(1))
                .delete(any(IncomeModel.class));
        verify(mockIncomePresenter, times(1))
                .presentIncomeSuccessfullyDeleted();
    }

    @Test
    @DisplayName("should not delete income when income is not found")
    void doNotDeleteIncomeWhenNotFound() {
        final Instant timestamp = Instant.ofEpochSecond(122);
        final IncomeModel incomeModel = IncomeTesterUtil.buildIncomeModel(BigDecimal.valueOf(99));
        when(mockIncomeRepository.findByTimeStampAndOwnerId(any(), anyString())).thenReturn(incomeModel);

        deleteIncome.invoke(timestamp, "manuel", BigDecimal.valueOf(100));

        verify(mockIncomeRepository, times(0))
                .delete(any(IncomeModel.class));
        verify(mockIncomePresenter, times(0))
                .presentIncomeSuccessfullyDeleted();
        verify(mockIncomePresenter, times(1))
                .presentIncomeCannotBeDeleted(anyString());
    }

    @Test
    @DisplayName("should not delete income when user is not found")
    void doNotDeleteIncomeWhenUserNotFound() {
        final Instant timestamp = Instant.ofEpochSecond(122);
        final IncomeModel incomeModel = IncomeTesterUtil.buildIncomeModel(BigDecimal.valueOf(100));
        when(mockIncomeRepository.findByTimeStampAndOwnerId(any(), anyString())).thenReturn(incomeModel);
        when(mockUserRepository.doesUserExist(anyString())).thenReturn(false);

        deleteIncome.invoke(timestamp, "manuel", BigDecimal.valueOf(100));

        verify(mockIncomeRepository, times(0))
                .delete(any(IncomeModel.class));
        verify(mockIncomePresenter, times(0))
                .presentIncomeSuccessfullyDeleted();
        verify(mockIncomePresenter, times(1))
                .presentIncomeCannotBeDeleted(anyString());
    }
}
