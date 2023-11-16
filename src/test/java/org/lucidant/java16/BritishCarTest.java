package org.lucidant.java16;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(value = Lifecycle.PER_CLASS)
class BritishCarTest {

    // We don’t need an else block as the sealed classes only allow  Mg and Leyland
    @Test
    void testEquality() {
        final BritishCar car = getInstance();

        if (car instanceof Mg m) {
            assertThat(m.isWillBreakdown()).isTrue();
        } else if (car instanceof Leyland s) {
            assertThat(s.isWillBreakdown()).isTrue();
        }
    }

    private BritishCar getInstance() {
        return new Mg("Birmingham");
    }

}
