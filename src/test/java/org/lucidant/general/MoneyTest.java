package org.lucidant.general;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MoneyTest {

    @Test
    void whenSumSameCurrency_thenReturnTotal() {
        var money1 = new Money(new BigDecimal("12.34"));
        var money2 = new Money(new BigDecimal("100.345"));

        assertThat(money1.getCurrency()).isNotNull();

        assertThat(money1.sum(List.of(money1, money2), Currency.getInstance("GBP"))).isEqualTo(new BigDecimal("112.69"));
    }

    @Test
    void whenDifferentCurrency_thenReturnMapWithTotals() {
        var money1 = new Money(new BigDecimal("25.34"));
        var money2 = new Money(new BigDecimal("25.00"));
        var money3 = new Money(new BigDecimal("100.345"));

        assertThat(money1.getCurrency()).isNotNull();

        assertThat(money1.sum(List.of(money1, money2, money3), Currency.getInstance("GBP")))
            .isEqualTo(new BigDecimal("150.69"));
    }


}
