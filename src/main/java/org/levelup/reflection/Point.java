package org.levelup.reflection;

public class Point {

    @RandomInt(min = 10, max = 30)
    public int y;

    @RandomInt(max = 25)
    private int x;

    @RandomInt(max = 15)
    private int z;

    public Point(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public Point(int x) {
        this.x = x;
    }

    private Point() {
    }

    private void changeYValue(int y) {
        this.y = y;
    }

    public void print() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }
}
