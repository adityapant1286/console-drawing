package com.console.drawing.shapes;

import static com.console.drawing.util.ValidationUtility.isNegativeOrZero;

public class BucketFill implements Shape {

    private int x;
    private int y;
    private String color;

    public BucketFill(int x, int y, String color) {

        if (isNegativeOrZero(x, y))
            throw new IllegalArgumentException(String.format("(x1=%d |y1=%d). All coordinates should be greater than zero", x, y));

        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() { return x; }

    public BucketFill setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() { return y; }

    public BucketFill setY(int y) {
        this.y = y;
        return this;
    }

    public String getColor() { return color; }

    public BucketFill setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BucketFill that = (BucketFill) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + color.hashCode();
        return result;
    }
}
