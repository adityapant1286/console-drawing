package com.console.drawing.commands;

import org.junit.Test;

public class DrawLineCommandTest {

    @Test
    public void testCreate() throws Exception {
        new DrawLineCommand("1", "1", "1", "2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate1() throws Exception {
        new DrawLineCommand("-1", "1", "1", "2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate2() throws Exception {
        new DrawLineCommand("1", "-1", "1", "2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate3() throws Exception {
        new DrawLineCommand("1", "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate4() throws Exception {
        new DrawLineCommand("1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate6() throws Exception {
        new DrawLineCommand();
    }
}
