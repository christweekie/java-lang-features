package org.lucidant.general;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.Optional;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.With;

@Data
@Getter
public final class Money {

    public Money (final BigDecimal amount, final Currency currency, final RoundingMode roundingMode) {
        this.amount = rounded(amount);
        this.currency = currency != null ? currency : DEFAULT_CURRENCY;
        this.roundingMode = roundingMode != null ? roundingMode : DEFAULT_ROUNDING_MODE;
    }

    public Money (final BigDecimal amount) {
        this(amount, null, null);
    }

    static final Currency DEFAULT_CURRENCY = Currency.getInstance("GBP");
    static RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;
    static int DECIMALS = 2;
    private final BigDecimal amount;
    private final Currency currency;
    private final RoundingMode roundingMode;

    BigDecimal rounded(BigDecimal number){
        return number.setScale(DECIMALS, DEFAULT_ROUNDING_MODE);
    }

    public BigDecimal sum(List<Money> monies, Currency currency) {
        var mc = new MathContext(100, DEFAULT_ROUNDING_MODE);
        var value = Optional.ofNullable(monies).orElse(Collections.emptyList())
            .stream()
            .filter(money -> money.getCurrency() == currency)
            .map(Money::getAmount)
            .reduce((a,b) -> a.add(b, mc));
        return value.get();
    }

    public int value() {
        return 19;
    }

    public int valueb2() {
        //b2
        return 2;
    }

}
