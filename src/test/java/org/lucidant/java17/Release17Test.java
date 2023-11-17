package org.lucidant.java17;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.lucidant.java16.Leyland;
import org.lucidant.java16.Mg;

import java.util.random.RandomGeneratorFactory;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(value = Lifecycle.PER_CLASS)
class Release17Test {

    /** Changes to random. (JEP36)    */
    @Test
    void proxyDefaultMethod()  {
        var av = getPseudoInts("L128X1024MixRandom", 10)
                .peek(System.out::println)
                .average();
        assertThat(av).isPresent();
    }

    /** Switch expression support.
     * Expression returns and can call a method
     * There's support for null
     *  */
    @Test
    void switchExpression()  {
        assertThat(formatterPatternSwitch(new Mg("Leicester"))).isEqualTo("Leicester");
        assertThat(formatterPatternSwitch(new Leyland("Leicester"))).isEqualTo("Leicester");
        assertThat(formatterPatternSwitch(null)).isEmpty();
    }

    public IntStream getPseudoInts(final String algorithm, final int streamSize) {
        // returns an IntStream with size @streamSize of random numbers generated using the @algorithm
        // where the lower bound is 0 and the upper is 100 (exclusive)
        return RandomGeneratorFactory.of(algorithm)
                .create()
                .ints(streamSize, 0, 100);
    }

    static String formatterPatternSwitch(Object o) {
        return switch (o) {
            case Mg mg -> mg.getOrigin();
            case Leyland leyland -> leyland.getOrigin();
            // Merge cases
            case null, default -> "";
        };
    }

}
