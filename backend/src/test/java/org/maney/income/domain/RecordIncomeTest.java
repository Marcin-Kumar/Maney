package org.maney.income.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.util.MockUtil.resetMock;


public class RecordIncomeTest {
    RecordIncome recordIncome;

    IncomeRepository mockIncomeRepository;
    IncomeCategoryRepository mockIncomeCategoryRepository;
    IncomePresenter mockIncomePresenter;

    @BeforeEach
    public void setup() {
        mockIncomeRepository = mock(IncomeRepository.class);
        mockIncomeCategoryRepository = mock(IncomeCategoryRepository.class);
        mockIncomePresenter = mock(IncomePresenter.class);

        recordIncome = new RecordIncome(
                mockIncomeRepository,
                mockIncomeCategoryRepository,
                mockIncomePresenter
        );

        final IncomeCategoryModel incomeCategoryModel = new IncomeCategoryModel("name", "description");
        when(mockIncomeCategoryRepository.findByName(anyString())).thenReturn(incomeCategoryModel);
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
        final Instant timestamp = Instant.ofEpochSecond(1000000);
        final IncomeModel incomeModel = new IncomeModel(
                BigDecimal.valueOf(100.0),
                "CHF",
                timestamp,
                "manuel",
                "miscellaneous"
        );

        recordIncome.invoke(incomeModel);

        verify(mockIncomeRepository, times(1))
                .save(any(IncomeModel.class));
    }
}
