package org.lucidant.lambda;

import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lombok.Lombok.sneakyThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @see "https://medium.com/javarevisited/3-lambda-quirks-every-java-developer-should-know-e704497f80ee"
 *
 * Can't throw checked exceptions from lambda. Can throw
 *
 */
class LambdaExceptionTest {

     final Function<String, Integer> func2 = (s) -> {
        if (s.equals("123")) {
            throw sneakyThrow(new Exception()) ;
        }
        return 1;
    };

    @DisplayName("Throw a checked exception with sneakyThrow")
    @Test
    void showLambdaThrow_AnException() {
        assertThrows(
            Exception.class,
            () -> func2.apply("123"),
            "Expected doThing() to throw, but it didn't"
        );
    }
}
