package org.levelup.reflection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    @Test
    public void shouldInvokePointConstructorWithOneXParameter() {
        //дано

        //что делаем
        Point point = new Point(5);
        //что должно получится
        assertEquals(5, point.getX());
        assertEquals(0, point.getY());
        assertEquals(0, point.getZ());
    }
}