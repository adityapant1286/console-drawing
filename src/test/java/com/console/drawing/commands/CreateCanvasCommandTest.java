package com.console.drawing.commands;

import org.junit.Test;

public class CreateCanvasCommandTest {

    @Test
    public void testCreate() throws Exception {
        new CreateCommand("1", "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate2() throws Exception {
        new CreateCommand("-11", "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate3() throws Exception {
        new CreateCommand("1", "-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate4() throws Exception {
        new CreateCommand("1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate6() throws Exception {
        new CreateCommand();
    }
    
}
