package org.lucidant.solid.liskov.compliant;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * We can substitute Square for rectangle without affecting correctness.
 * getArea in Rectangle still works
 */
class SquareTest {

    @Test
    void testSetLength() {
        Square square = new Square(10);
        square.setWidth(5);
        square.setLength(10);

        assertThat(square.getLength()).isEqualTo(10);
        assertThat(square.getWidth()).isEqualTo(10);
        assertThat(square.getArea()).isEqualTo(100);
    }

}
