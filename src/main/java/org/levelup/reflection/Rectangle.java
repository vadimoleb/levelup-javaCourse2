package org.levelup.reflection;

public class Rectangle {

    private int width;
    private int height;

    private Rectangle(){}

    public Rectangle(int width, int height){
        this.height = height;
        this.width = width;
    }

    public int square(){
        return this.width * this.height;
    }

    private int perimeter(){
        return 2*(this.width+this.height);
    }

    private void scale (int value){
        this.height = this.height * value;
        this.width = this.width * value;
    }

    public void print() {
        System.out.println("(" + width + ", " + height + ")");
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }

}
