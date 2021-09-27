package org.lucidant.general;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.Data;

/**
 * Created this to play with {@link RoundingMode}
 */
@Data
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
        return this.amount1.add(amount2);
    }
}
