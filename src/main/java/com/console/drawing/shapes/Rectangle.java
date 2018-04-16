package com.console.drawing.shapes;

import java.awt.*;
import java.beans.Transient;

import static com.console.drawing.util.ValidationUtility.isNegativeOrZero;
import static com.console.drawing.util.ValidationUtility.isOutOfScreen;

public class Rectangle implements Shape {

    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {

        if (isNegativeOrZero(x, y, width, height))
            throw new IllegalArgumentException(String.format("(x1=%d |y1=%d) (x2=%d |y2=%d). All coordinates should be greater than zero",
                                                x, y, width, height));
        if (isOutOfScreen(x, y, width, height))
            throw new IllegalArgumentException(String.format("(x1=%d |y1=%d) (width=%d |height=%d). One or all coordinates out of screen size",
                    x, y, width, height));

        if ((x == width && y > height) || (y == height && x > width))
            setRectangle(width, height, x, y);
        else
            setRectangle(x, y, width, height);
    }

    public void setRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Transient
    public Rectangle getBounds() { return new Rectangle(x, y, width, height); }

    public int getX() { return x; }

    public Rectangle setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() { return y; }

    public Rectangle setY(int y) {
        this.y = y;
        return this;
    }

    public int getWidth() { return width; }

    public Rectangle setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() { return height; }

    public Rectangle setHeight(int height) {
        this.height = height;
        return this;
    }

    public Point getLocation() { return new Point(x, y); }

    public void setLocation(Point p) { setLocation(p.getX(), p.getY()); }

    public void setLocation(int x, int y) { move(x, y); }

    public void move(int x, int y) { this.x = x; this.y = y; }


    public Dimension getSize() { return new Dimension(width, height); }

    public void setSize(Dimension d) { setSize(d.width, d.height); }

    public void setSize(int width, int height) { resize(width, height); }

    public void resize(int width, int height) { this.width = width; this.height = height; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;
        if (x != rectangle.x) return false;
        if (y != rectangle.y) return false;
        if (width != rectangle.width) return false;
        return height == rectangle.height;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }
}
