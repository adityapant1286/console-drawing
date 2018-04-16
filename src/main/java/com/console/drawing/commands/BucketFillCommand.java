package com.console.drawing.commands;

import static com.console.drawing.util.ValidationUtility.toPositiveInt;

public class BucketFillCommand implements DrawShapeCommand {
    private static final String helpMessage = "B x y c         Should fill the entire area connected to (x,y) with \"colour\" c. The\n" +
            "                behaviour of this is the same as that of the \"bucket fill\" tool in paint\n" +
            "                programs.";

    private int x;
    private int y;
    private String color;

    public BucketFillCommand(String... params) {

        if (params.length < 3)
            throw new IllegalArgumentException(String.format("Bucket fill expects 3 params. \n%s", helpMessage));

        if (params[2].length() != 1)
            throw new IllegalArgumentException(String.format("Color character should only be 1 character. \n%s", helpMessage));

        x = toPositiveInt(params[0]);
        y = toPositiveInt(params[1]);
        color = params[2];
    }

    public int getX() { return x; }

    public BucketFillCommand setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() { return y; }

    public BucketFillCommand setY(int y) {
        this.y = y;
        return this;
    }

    public String getColor() { return color; }

    public BucketFillCommand setColor(String color) {
        this.color = color;
        return this;
    }
}
