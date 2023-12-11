package org.lucidant.java21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringTemplateTest {

    @Test
    void simpleStringTemplate() {
        final var value = "insert";

        // STR is the processor Template Processor
        assertThat(STR."Variable: \{value}. Method: \{aMethod()}").isEqualTo("Variable: insert. Method: false");
    }

    boolean aMethod() {
        return false;
    }

}
