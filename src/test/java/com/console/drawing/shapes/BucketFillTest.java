package com.console.drawing.shapes;

import org.junit.Test;

public class BucketFillTest {

    @Test
    public void create() throws Exception {
        new BucketFill(1, 2, "r");
    }

    @Test(expected = IllegalArgumentException.class)
    public void create3() throws Exception {
        new BucketFill(-1, 2, "b");
    }

    @Test(expected = IllegalArgumentException.class)
    public void create4() throws Exception {
        new BucketFill(1, -2, "g");
    }
}
