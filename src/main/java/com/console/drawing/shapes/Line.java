package com.console.drawing.shapes;

import static com.console.drawing.util.ValidationUtility.isNegativeOrZero;
import static com.console.drawing.util.ValidationUtility.isOutOfScreen;

public class Line implements Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {

        if (x1 != x2 && y1 != y2)
            throw new IllegalArgumentException(String.format("(x1=%d |y1=%d) (x2=%d |y2=%d). Draw line does not support diagonal line at the moment.",
                                                x1, y1, x2, y2));

        if (isNegativeOrZero(x1, y1, x2, y2))
            throw new IllegalArgumentException(String.format("(x1=%d |y1=%d) (x2=%d |y2=%d). All coordinates should be greater than zero",
                                                x1, y1, x2, y2));

        if (isOutOfScreen(x1, y1, x2, y2))
            throw new IllegalArgumentException(String.format("(x1=%d |y1=%d) (x2=%d |y2=%d). One or all coordinates out of screen size",
                                                x1, y1, x2, y2));

        if ((this.x1 == this.x2 && this.y1 > this.y2)
                || (this.y1 == this.y2 && this.x1 > this.x2))
            setLine(x2, y2, x1, y1);
        else
            setLine(x1, y1, x2, y2);
    }

    public void setLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setLine(Point p1, Point p2) { setLine(p1.getX(), p1.getY(), p2.getX(), p2.getY()); }

    public void setLine(Line l) { setLine(l.getX1(), l.getY1(), l.getX2(), l.getY2()); }

    public int getX1() { return x1; }

    public Line setX1(int x1) {
        this.x1 = x1;
        return this;
    }

    public int getY1() { return y1; }

    public Line setY1(int y1) {
        this.y1 = y1;
        return this;
    }

    public int getX2() { return x2; }

    public void setX2(int x2) { this.x2 = x2; }

    public int getY2() { return y2; }

    public void setY2(int y2) { this.y2 = y2; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;
        if (x1 != line.x1) return false;
        if (y1 != line.y1) return false;
        if (x2 != line.x2) return false;
        return y2 == line.y2;
    }

    @Override
    public int hashCode() {
        int result = x1;
        result = 31 * result + y1;
        result = 31 * result + x2;
        result = 31 * result + y2;
        return result;
    }
}
