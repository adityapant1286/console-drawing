package com.console.drawing.shapes;

import java.awt.*;

/**
 * Marker interface
 */
public interface Shape {
    Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    Double WIDTH = SCREEN_SIZE.getWidth();

    Double HEIGHT = SCREEN_SIZE.getHeight();

}
