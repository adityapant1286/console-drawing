package com.console.drawing.commands;

import static com.console.drawing.util.ValidationUtility.toPositiveInt;

public class DrawLineCommand implements DrawShapeCommand {

    private static final String helpMessage = "L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only\n" +
            "                horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
            "                will be drawn using the 'x' character.";

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public DrawLineCommand(String... params) {

        if (params.length < 4)
            throw new IllegalArgumentException(String.format("Draw line command expects 4 params. \n%s", helpMessage));

            x1 = toPositiveInt(params[0]);
            y1 = toPositiveInt(params[1]);
            x2 = toPositiveInt(params[2]);
            y2 = toPositiveInt(params[3]);

        if (x1 != x2 && y1 != y2)
            throw new IllegalArgumentException(String.format("Draw line does not support diagonal line at the moment. \n%s", helpMessage));
    }

    public int getX1() { return x1; }

    public DrawLineCommand setX1(int x1) {
        this.x1 = x1;
        return this;
    }

    public int getY1() { return y1; }

    public DrawLineCommand setY1(int y1) {
        this.y1 = y1;
        return this;
    }

    public int getX2() { return x2; }

    public DrawLineCommand setX2(int x2) {
        this.x2 = x2;
        return this;
    }

    public int getY2() { return y2; }

    public DrawLineCommand setY2(int y2) {
        this.y2 = y2;
        return this;
    }
}
