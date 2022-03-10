package org.lucidant.java8;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Java 8 gives
 * <ul>
 * <li>static methods</li>
 * <li>default method implementations</li>
 * <li>functional interfaces</li>
 * </ul>
 *
 * The FunctionalInterface annotation seems to add little, compiler would stop us adding a second unimplemented
 */
@FunctionalInterface
public interface DefaultInterface {

    // functional - see test class
    int addThem(int op1, int op2);

    default void printUtf8To(String text, OutputStream outputStream){
        try {
            outputStream.write(text.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Error writing String as UTF-8 to OutputStream", e);
        }
    }

    static int multiplyThem(int op1, int op2){
        return op1 * op2;
    }

}
