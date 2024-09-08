package income.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.maney.income.domain.Currency;
import org.maney.income.domain.Income;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncomeEntityTest {

    public static final Currency CURRENCY = Currency.SWISS_FRANK;

    @ParameterizedTest
    @ValueSource(doubles = {12, 1000.99, -2, -0.0})
    void testIncomeToString(double inputAmount) {
        final Income income = new Income(inputAmount, CURRENCY);

        if(inputAmount < 0) {
            assertEquals(String.valueOf(Math.abs(inputAmount)) + CURRENCY, income.toString());
        } else {
            assertEquals(String.valueOf(inputAmount) + CURRENCY, income.toString());
        }
    }
}
