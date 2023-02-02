package org.lucidant.general;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Created this to play with {@link RoundingMode}
 */
@Data
@Slf4j
public class BigDecimalRound {

    private static RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private static int DECIMALS = 2;

    private final BigDecimal amount1;

    private final BigDecimal amount2;

    public BigDecimalRound(BigDecimal amountOne, BigDecimal amountTwo){
        this.amount1 = rounded(amountOne);
        this.amount2 = rounded(amountTwo);
    }

    BigDecimal rounded(BigDecimal number){
        return number.setScale(DECIMALS, ROUNDING_MODE);
    }

    public BigDecimal sum() {
        log.info("Adding {} to {}", amount1, amount2);
        return this.amount1.add(amount2);
    }
}
