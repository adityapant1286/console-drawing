package com.console.drawing.commands;

import static com.console.drawing.util.ValidationUtility.toPositiveInt;

public class CreateCommand implements Command {

    private static String helpMessage = "C w h           Should create a new canvas of width w and height h. w, h should be > 0";
    private int height;
    private int width;

    public CreateCommand(String... params) {

        if (params.length < 2)
            throw new IllegalArgumentException(String.format("Create command expects 2 params.\n%s", helpMessage));

        width = toPositiveInt(params[0]);
        height = toPositiveInt(params[1]);
    }

    public int getHeight() { return height; }

    public CreateCommand setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() { return width; }

    public CreateCommand setWidth(int width) {
        this.width = width;
        return this;
    }
}
