package org.maney.income.domain;

import java.math.BigDecimal;
import java.time.Instant;

class IncomeTesterUtil {
    static IncomeModel buildIncomeModel(BigDecimal amountToSet) {
        final BigDecimal amount = (amountToSet == null)
                ? BigDecimal.valueOf(100.0)
                : amountToSet;
        final Instant timestamp = Instant.ofEpochSecond(1000000);

        return new IncomeModel(
                amount,
                "CHF",
                timestamp,
                "manuel",
                "miscellaneous"
        );
    }
}
