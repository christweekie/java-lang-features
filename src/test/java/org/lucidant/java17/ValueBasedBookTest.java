package org.lucidant.java17;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ValueBasedBookTest {

    @Test
    void checkValues() {
        final var b1 = ValueBasedBook.valueOf(10, 10);
        assertThat(b1.getP1()).isEqualTo(10);
        assertThat(b1.getP2()).isEqualTo(10);
    }

}