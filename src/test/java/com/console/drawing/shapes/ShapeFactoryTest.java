package com.console.drawing.shapes;

import com.console.drawing.commands.BucketFillCommand;
import com.console.drawing.commands.DrawLineCommand;
import com.console.drawing.commands.DrawRectangleCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShapeFactoryTest {

    private ShapeFactory shapeFactory;

    @Before
    public void setUp() throws Exception {
        shapeFactory = new ShapeFactory();
    }

    @Test
    public void getShape_DrawLineCommand() throws Exception {
        DrawLineCommand drawLineCommand = new DrawLineCommand( "1", "2", "1", "4");
        assertEquals(shapeFactory.getShape(drawLineCommand), new Line(1, 2, 1, 4));
    }

    @Test
    public void getShape_DrawRectangleCommand() throws Exception {
        DrawRectangleCommand drawLineCommand = new DrawRectangleCommand( "1", "2", "3", "4");
        assertEquals(shapeFactory.getShape(drawLineCommand), new Rectangle(1, 2, 3, 4));
    }

    @Test
    public void getShape_BucketFillCommand() throws Exception {
        BucketFillCommand drawLineCommand = new BucketFillCommand( "2", "3", "r");
        assertEquals(shapeFactory.getShape(drawLineCommand), new BucketFill(2, 3, "r"));
    }

    @Test
    public void getShape_null() throws Exception {
        assertEquals(shapeFactory.getShape(null), null);
    }
}
