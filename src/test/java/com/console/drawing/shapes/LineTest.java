package com.console.drawing.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineTest {

    @Test
    public void create() throws Exception {
        new Line(1, 2, 1, 3);
    }

    @Test
    public void create2() throws Exception {
        Line line1 = new Line(1, 2, 1, 3);
        Line line2 = new Line(1, 2, 1, 3);
        assertEquals(line1, line2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create3() throws Exception {
        new Line(-1, 2, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create4() throws Exception {
        new Line(1, -2, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create5() throws Exception {
        new Line(1, 2, -1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create6() throws Exception {
        new Line(1, 2, 1, -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create7() throws Exception {
        new Line(1, 2, 3, 4);
    }

}
