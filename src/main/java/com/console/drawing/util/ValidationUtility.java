package com.console.drawing.util;

import com.console.drawing.shapes.Shape;

import java.util.Arrays;

public final class ValidationUtility {

    private static final String NUMERIC = "\\d+";

    private ValidationUtility() { }

    /**
     * n < 0
     * @param numbers to be validated
     * @return {@code true} if any number is < 0 (i.e. negative), otherwise {@code false}
     */
    public static boolean isNegative(Integer...numbers) {

        return Arrays.stream(numbers).anyMatch(n -> Integer.signum(n) < 0);
    }

    public static boolean isNumeric(String number) {
        return number.matches(NUMERIC);
    }

    public static int toPositiveInt(String number) {

        if(!isNumeric(number))
            throw new IllegalArgumentException(String.format("Please enter numeric (%s)", number));

        int num = Integer.valueOf(number);

        if (num < 1)
            throw new IllegalArgumentException(String.format("Number should be greater than zero (%s)", number));

        return num;
    }

    /**
     * n < 1
     * @param numbers to be validated
     * @return {@code true} if any number is <= 0 (i.e. zero or negative), otherwise {@code false}
     */
    public static boolean isNegativeOrZero(Integer...numbers) {

        return Arrays.stream(numbers).anyMatch(n -> Integer.signum(n) < 1);
    }

    public static boolean isOutOfScreen(int x, int y) {
        return isNegative(x, y) || x > Shape.WIDTH || y > Shape.HEIGHT;
    }

    public static boolean isOutOfScreen(int x1, int y1, int x2, int y2) {
        return isNegative(x1, y1) || isNegative(x2, y2)
                || x1 > Shape.WIDTH || y1 > Shape.HEIGHT
                || x2 > Shape.WIDTH || y2 > Shape.HEIGHT;
    }
}
