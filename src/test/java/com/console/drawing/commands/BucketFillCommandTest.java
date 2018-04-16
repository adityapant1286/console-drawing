package com.console.drawing.commands;

import org.junit.Test;

public class BucketFillCommandTest {
    @Test
    public void testCreate() throws Exception {
        new BucketFillCommand("1", "1", "o");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate1() throws Exception {
        new BucketFillCommand("-1", "1", "o");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate2() throws Exception {
        new BucketFillCommand("1", "-1", "o");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate3() throws Exception {
        new BucketFillCommand("1", "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate4() throws Exception {
        new BucketFillCommand("1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate6() throws Exception {
        new BucketFillCommand();
    }

}
