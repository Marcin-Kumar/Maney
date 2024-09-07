package income.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.maney.income.domain.Currency;
import org.maney.income.domain.Income;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncomeEntityTest {

    public static final Currency CURRENCY = Currency.SWISS_FRANK;

    @ParameterizedTest
    @ValueSource(doubles = {12, 1000.99, -2})
    void testIncomeToString(double amount) {
        final Income income = new Income(amount, CURRENCY);

        assertEquals(String.valueOf(amount) + CURRENCY, income.toString());
    }
}
