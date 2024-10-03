package org.maney.income.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncomeEntityEntityTest {

    public static final Currency SWISS_FRANK =  Currency.getInstance("CHF");
    public static final String UNCATEGORIZED = "UNCATEGORIZED";
    public static final String OWNER_ID = "OWNER_ID";

    @Test
    @DisplayName("WHEN a negative amount is provided " +
            "THEN the absolute value is taken")
    void testIncomeWithNegativeAmount() {
        final IncomeEntity incomeEntity = new IncomeEntity(BigDecimal.valueOf(-100.0), SWISS_FRANK, OWNER_ID);

        assertEquals(BigDecimal.valueOf(100.0), incomeEntity.amount);
    }

    @ParameterizedTest
    @DisplayName("IncomeEntity.toString() returns {amount} {currency symbol} (eg: 100 CHF)")
    @ValueSource(doubles = {12, 1000.99, -2, -0.0, 0})
    void testIncomeToString(double inputAmount) {
        final IncomeEntity incomeEntity = new IncomeEntity(BigDecimal.valueOf(inputAmount), SWISS_FRANK, OWNER_ID);

        if(inputAmount <= 0) {
            assertEquals(Math.abs(inputAmount)
                    + " "
                    + SWISS_FRANK, incomeEntity.toString());
        } else {
            assertEquals(inputAmount
                    + " "
                    + SWISS_FRANK, incomeEntity.toString());
        }
    }

    @Test
    @DisplayName("WHEN no category is provided " +
            "THEN category is set to "+ UNCATEGORIZED)
    void testCategoryNotSpecified() {
        final IncomeEntity incomeEntity = new IncomeEntity(BigDecimal.valueOf(100.5), SWISS_FRANK, OWNER_ID);

        assertEquals(UNCATEGORIZED, incomeEntity.category.name);
        assertEquals("", incomeEntity.category.description);
    }

    @Test
    @DisplayName("WHEN category is provided " +
            "THEN category is set")
    void testCategorySpecified() {
        String name = "name";
        String description = "description";
        final IncomeEntity incomeEntity = new IncomeEntity(BigDecimal.valueOf(100),
                SWISS_FRANK,
                new IncomeCategoryEntity(name, description),
                OWNER_ID
                );

        assertEquals(name, incomeEntity.category.name);
        assertEquals(description, incomeEntity.category.description);
    }
}
