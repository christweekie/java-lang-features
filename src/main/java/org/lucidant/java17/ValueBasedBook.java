package org.lucidant.java17;

import lombok.Getter;

/**
 * Added in Java 8 but many upgrades since then.
 * Value based classes
 * - stored on the stack, not heap. Not objects so no header, no equality, etc.
 * - see optional, don't use for synchronisation
 * - should only be created with factories
 * - like primitives, not accessed by reference
 * - they don't have identity
 */
@jdk.internal.ValueBased
public final class ValueBasedBook {
    private final int p1;
    private final int p2;

    private ValueBasedBook(final int p1, final int p2) {
        this.p2 = p2;
        this.p1 = p1;
    }

    public static ValueBasedBook valueOf(int x, int y) {
        return new ValueBasedBook(x, y);
    }

    public int getP1() {
        return p1;
    }

    public int getP2() {
        return p2;
    }
}
