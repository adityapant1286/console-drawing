package com.console.drawing.commands;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class CommandFactoryTest {

    private CommandFactory commandFactory;

    @Before
    public void setUp() throws Exception {
        commandFactory = new CommandFactory();
    }

    @Test
    public void getCommand() throws Exception {
        commandFactory.getCommand("Q");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCommand2() throws Exception {
        commandFactory.getCommand("A");
    }

    @Test
    public void getCommand3() throws Exception {
        Command command = commandFactory.getCommand("C 20 4");
        assertThat(command, instanceOf(CreateCommand.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCommand32() throws Exception {
        commandFactory.getCommand("C 20 -4");
    }

    @Test
    public void getCommand4() throws Exception {
        Command command = commandFactory.getCommand("L 1 2 1 22");
        assertThat(command, instanceOf(DrawLineCommand.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCommand42() throws Exception {
        commandFactory.getCommand("L 1 2 1 -22");
    }

    @Test
    public void getCommand5() throws Exception {
        Command command = commandFactory.getCommand("R 14 1 18 3");
        assertThat(command, instanceOf(DrawRectangleCommand.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCommand52() throws Exception {
        commandFactory.getCommand("R 14 1 18 -3");
    }

    @Test
    public void getCommand6() throws Exception {
        Command command = commandFactory.getCommand("B 1 3 o");
        assertThat(command, instanceOf(BucketFillCommand.class));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void getCommand62() throws Exception {
        commandFactory.getCommand("B 1 3 oo");
    }
}
