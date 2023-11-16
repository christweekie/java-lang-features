package org.lucidant.java16;

import lombok.Data;

@Data
public sealed class BritishCar permits Mg, Leyland {
    private final boolean willBreakdown = true;

    protected final String origin;

    public BritishCar(String origin) {
        this.origin = origin;
    }
}
