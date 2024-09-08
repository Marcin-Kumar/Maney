package income.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.maney.income.domain.Currency;
import org.maney.income.domain.Income;
import org.maney.income.domain.IncomeCategory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncomeEntityTest {

    public static final Currency CURRENCY = Currency.SWISS_FRANK;
    public static final String UNCATEGORIZED = "UNCATEGORIZED";

    @Test
    @DisplayName("WHEN a negative amount is provided " +
            "THEN the absolute value is taken")
    void testIncomeWithNegativeAmount() {
        final Income income = new Income(-100, Currency.SWISS_FRANK);

        assertEquals(100, income.get_amount());
    }

    @ParameterizedTest
    @DisplayName("Income.toString() returns {amount} {currency symbol} (eg: 100 CHF)")
    @ValueSource(doubles = {12, 1000.99, -2, -0.0})
    void testIncomeToString(double inputAmount) {
        final Income income = new Income(inputAmount, CURRENCY);

        if(inputAmount < 0) {
            assertEquals(String.valueOf(Math.abs(inputAmount))
                    + " "
                    + CURRENCY, income.toString());
        } else {
            assertEquals(String.valueOf(inputAmount)
                    + " "
                    + CURRENCY, income.toString());
        }
    }

    @Test
    @DisplayName("WHEN no category is provided " +
            "THEN category is set to "+ UNCATEGORIZED)
    void testCategoryNotSpecified() {
        final Income income = new Income(100, Currency.SWISS_FRANK);

        assertEquals(UNCATEGORIZED, income.get_category().get_name());
        assertEquals("", income.get_category().get_description());
    }

    @Test
    @DisplayName("WHEN category is provided " +
            "THEN category is set")
    void testCategorySpecified() {
        String name = "name";
        String description = "description";
        final Income income = new Income(100,
                Currency.SWISS_FRANK,
                new IncomeCategory(name, description)
        );

        assertEquals(name, income.get_category().get_name());
        assertEquals(description, income.get_category().get_description());
    }
}
