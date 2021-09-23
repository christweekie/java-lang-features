package org.lucidant.java11;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class StringIterableTest {

    @BeforeEach
    void beforeEach() {

    }

    @DisplayName("Traditional inner private class")
    @Test
    void stringIterable() {
        for (Character character : new StringIterable("abc")) {
            log.info("Next character {}", character);
        }
    }
}
