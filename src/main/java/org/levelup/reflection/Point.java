package org.levelup.reflection;

public class Point {

    public int y;

    private int x;

    public Point(int x, int y){
        this.y = y;
        this.x = x;
    }

    public Point (int x){
        this.x=x;
    }

    private Point (){}

    private void changeYValue(int y){
        this.y = y;
    }

    public void print(){
        System.out.println("("+x+", "+y+")");
    }
}
