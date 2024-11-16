package org.lucidant.solid.liskov.compliant;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }
}
