package org.lucidant.general;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BigDecimalRoundTest {

    @DisplayName("Round BD with 3 places")
    @Test
    void givenInputWithThreeDecimal_whenRound_thenRoundToTwo() {
        var bd1 = new BigDecimal("3.499");
        var bd2 = new BigDecimal("2.501");

        var moneyCalculator = new BigDecimalRound(bd1, bd2);
        assertThat(moneyCalculator.getAmount1()).isEqualTo("3.50");
        assertThat(moneyCalculator.getAmount2()).isEqualTo("2.50");
    }

    @DisplayName("Round BD with 1 places")
    @Test
    void givenInputWithOneDecimal_whenRound_thenRoundToTwo() {
        var bd1 = new BigDecimal("3.4");
        var bd2 = new BigDecimal("2.9");

        var moneyCalculator = new BigDecimalRound(bd1, bd2);
        assertThat(moneyCalculator.getAmount1()).isEqualTo("3.40");
        assertThat(moneyCalculator.getAmount2()).isEqualTo("2.90");
    }

    @DisplayName("Sum with 3 decimal places")
    @Test
    void givenInputWithThreeDecimal_whenSum_thenRoundToTwo() {
        var bd1 = new BigDecimal("3.501");
        var bd2 = new BigDecimal("2.99");

        var moneyCalculator = new BigDecimalRound(bd1, bd2);

        assertThat(moneyCalculator.sum()).isEqualTo("6.49");
    }

    @DisplayName("Sum with 1 decimal place")
    @Test
    void givenInputWithOneDecimal_whenSum_thenRoundToTwo() {
        var bd1 = new BigDecimal("3.5");
        var bd2 = new BigDecimal("2.9");

        var moneyCalculator = new BigDecimalRound(bd1, bd2);

        assertThat(moneyCalculator.sum()).isEqualTo("6.40");
    }

}
