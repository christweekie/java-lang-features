package org.lucidant.solid.liskov.compliant;

/**
 * We can substitute Square for rectangle without affecting correctness.
 * getArea in Rectangle still works
 */
public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(int width) {
        super.setLength(width);
        super.setWidth(width);
    }
}
