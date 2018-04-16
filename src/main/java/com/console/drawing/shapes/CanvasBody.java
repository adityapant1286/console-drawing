package com.console.drawing.shapes;

import com.console.drawing.util.ConsoleColors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CanvasBody implements Canvas {

    private static final String HORIZONTAL_EDGE_CHAR = "x";
    private static final String VERTICAL_EDGE_CHAR   = "x";
    private static final String LINE_CHAR            = "x";

    private final String[][] canvasMatrix;
    private final int width;
    private final int height;

    // to support advanced operation such as: undo, redo
    private List<Shape> shapes;

    private final String horizontalEdge;

    public CanvasBody(int w, int h) {

        width = w;
        height = h;
        shapes = new LinkedList<>();

        canvasMatrix = new String[this.height][this.width];
        Arrays.stream(canvasMatrix).forEach(chars -> Arrays.fill(chars, " "));

        horizontalEdge = Stream.generate(() -> String.valueOf(HORIZONTAL_EDGE_CHAR))
                                .limit(width + 2)
                                .collect(Collectors.joining());
    }

    @Override
    public void addShape(Shape shape) {

        shapes.add(shape);

        if (shape instanceof Line)
            addLine((Line) shape);

        else if (shape instanceof Rectangle)
            addRectangle((Rectangle) shape);

        else if (shape instanceof BucketFill)
            addBucketFill((BucketFill) shape);
    }

    @Override
    public String render() {

        final StringBuilder builder = new StringBuilder();

        builder.append(horizontalEdge).append("\n");

        for (int i = 0; i < this.height; i++) {
            builder.append(VERTICAL_EDGE_CHAR);

            for (int j = 0; j < this.width; j++)
                builder.append(canvasMatrix[i][j]);

            builder.append(VERTICAL_EDGE_CHAR);
            builder.append("\n");
        }

        builder.append(horizontalEdge);
        return builder.toString();
    }

    private void addBucketFill(BucketFill bucketFill) {

        if (isOutside(bucketFill.getX(), bucketFill.getY()))
            throw new InvalidShapeException("Bucket fill point is outside of canvas");

        fillBucket(bucketFill.getX(), bucketFill.getY(), bucketFill.getColor());
    }

    private void addRectangle(Rectangle rec) {

        if (isOutside(rec.getX(), rec.getY()))
            throw new InvalidShapeException("Rectangle is outside of canvas");

        drawRectangle(rec.getX(), rec.getY(), rec.getWidth(), rec.getHeight());
    }

    private void addLine(Line line) {

        if (isOutside(line.getX1(), line.getY1()))
            throw new InvalidShapeException("Line is outside of canvas");

        if (line.getX2() >= width)
            line.setX2(width);

        if (line.getY2() >= height)
            line.setY2(height);

        drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
    }

    private void drawLine(int x1, int y1, int x2, int y2) {

        //each
        for (int row = y1 - 1; row <= y2 - 1 && row < height; row++)
            //col
            for (int col = x1 - 1; col <= x2 - 1 && col < width; col++)
                canvasMatrix[row][col] = CanvasBody.LINE_CHAR;
    }

    private void fillBucket(int x, int y, String color) {

        String originalChar = canvasMatrix[y - 1][x - 1];

        String colr = getConsoleColor(color) + LINE_CHAR + ConsoleColors.RESET;

        Stack<Point> stack = new Stack<>();

        stack.add(new Point(y - 1, x - 1));

        while (!stack.isEmpty()) {

            Point pop = stack.pop();

            if (canvasMatrix[pop.getX()][pop.getY()] == originalChar)
                canvasMatrix[pop.getX()][pop.getY()] = colr;

            if (pop.getX() - 1 >= 0 && canvasMatrix[pop.getX() - 1][pop.getY()] == originalChar)
                stack.add(new Point(pop.getX() - 1, pop.getY()));

            if (pop.getX() + 1 < height && canvasMatrix[pop.getX() + 1][pop.getY()] == originalChar)
                stack.add(new Point(pop.getX() + 1, pop.getY()));

            if (pop.getY() - 1 >= 0 && canvasMatrix[pop.getX()][pop.getY() - 1] == originalChar)
                stack.add(new Point(pop.getX(), pop.getY() - 1));

            if (pop.getY() + 1 < width && canvasMatrix[pop.getX()][pop.getY() + 1] == originalChar)
                stack.add(new Point(pop.getX(), pop.getY() + 1));
        }
    }

    private String getConsoleColor(String color) {
        color = color.toUpperCase();

        switch (color) {
            case "R": return ConsoleColors.RED;
            case "G": return ConsoleColors.GREEN;
            case "Y": return ConsoleColors.YELLOW;
            case "B": return ConsoleColors.BLUE;
            case "P": return ConsoleColors.PURPLE;
            case "C": return ConsoleColors.CYAN;
            case "W": return ConsoleColors.WHITE;
            default: return ConsoleColors.RESET;
        }
    }

    private void drawRectangle(int x1, int y1, int x2, int y2) {
        //top edge
        drawLine(x1, y1, x2, y1);

        //right edge
        drawLine(x1, y1, x1, y2);

        //bottom edge
        drawLine(x2, y1, x2, y2);

        //right edge
        drawLine(x1, y2, x2, y2);
    }

    private boolean isOutside(int x, int y) {
        return x < 1 || x >= width || y < 1 || y >= height;
    }
}
