package org.lucidant.java8;

import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DefaultInterfaceTest {

    @SuppressWarnings("Convert2MethodRef")
    @Test
    void givenFunctionalInterface_thenImplement_andTest() {

        // This implements the interface definition in DefaultInterface. An expression lambda
        // Could just use a BiFunction and many of the built-ins but maybe better to rename method and do this
        DefaultInterface myInterface = (int op1, int op2) -> op1 + op2;

        assertThat(myInterface.addThem(1, 2)).isEqualTo(3);
    }

    @Test
    void givenStaticMethodInterface() {
        assertThat(DefaultInterface.multiplyThem(1, 2)).isEqualTo(2);
    }

    @Test
    void givenFunctionalInterface_useMethodReference() {
        Finder finder = String::indexOf;

        assertThat(finder.find("The Fantastic Mr Fox jumped over the lazy brown dog.", "z")).isEqualTo(39);

    }

    @Test
    void givenLambda_useMethodReference() {
        BiFunction<String, String, Integer> finder = String::indexOf;

        assertThat(finder.apply("The Fantastic Mr Fox jumped over the lazy brown dog.", "z")).isEqualTo(39);

    }

    interface Finder {
        int find(String s1, String s2);
    }
}
