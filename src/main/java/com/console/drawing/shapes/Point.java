package com.console.drawing.shapes;

import java.beans.Transient;

import static com.console.drawing.util.ValidationUtility.isNegative;
import static com.console.drawing.util.ValidationUtility.isOutOfScreen;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {

        if (isNegative(x, y))
            throw new IllegalArgumentException(String.format("One of the input is negative. (x=%d | y=%d)", x, y));

        if (isOutOfScreen(x, y))
            throw new IllegalArgumentException(String.format("Coordinates are out screen. (x=%d | y=%d)", x, y));

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public Point setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Point setY(int y) {
        this.y = y;
        return this;
    }

    @Transient
    public Point getLocation() { return new Point(x, y); }

    public void setLocation(Point p) { setLocation(p.x, p.y); }

    private void setLocation(int x, int y) { move(x, y); }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
