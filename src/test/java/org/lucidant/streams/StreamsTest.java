package org.lucidant.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.lucidant.general.Money;
import org.lucidant.general.Name;

import static org.assertj.core.api.Assertions.assertThat;

class StreamsTest {

    @Test
    void reduceSumWithLambda(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = integers.stream()
            .reduce(0, this::myAdd);

        assertThat(sum).isEqualTo(15);
    }

    @Test
    void reduceSumWithCollectors(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = integers.stream()
            .collect(Collectors.summingInt(Integer::intValue));

        assertThat(sum).isEqualTo(15);
    }

    @Test
    void whenCollectToMap() {
        var usd = Currency.getInstance("USD");
        var gbp = Currency.getInstance("GBP");
        var money1 = new Money(new BigDecimal("25.34"));
        var money2 = new Money(new BigDecimal("25.00"));
        var money3 = new Money(new BigDecimal("100.345"), usd, null);

        var monies = List.of(money1, money2, money3);
        Map<Currency, BigDecimal> sumByCurrency = monies.stream().collect(
            Collectors.groupingBy(Money::getCurrency, Collectors.reducing(
                BigDecimal.ZERO,
                Money::getAmount,
                BigDecimal::add)));

        assertThat(sumByCurrency).hasSize(2);
        assertThat(sumByCurrency.get(usd)).isEqualTo("100.35");
        assertThat(sumByCurrency.get(gbp)).isEqualTo("50.34");
    }

    @Test
    void whenFlatMap() {
        var name1 = Name.builder().forename1("Chris").middleNames(List.of("James", "Brown")).surname("Faulkner").build();
        var name2 = Name.builder().forename1("Liz").middleNames(List.of("Brown", "Elizabeth")).surname("Windsor").build();

        var names = List.of(name1, name2);

        var allMiddleNames = names.stream()
                .flatMap(name -> name.getMiddleNames().stream())
                .distinct()
                .collect(Collectors.toList());

        assertThat(allMiddleNames).hasSize(3);
    }

    private Integer myAdd(Integer a, Integer b) {
        return a + b;
    }
}
