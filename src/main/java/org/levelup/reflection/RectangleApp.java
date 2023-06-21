package org.levelup.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RectangleApp {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Rectangle rectangle = new Rectangle(3, 2);
        Class<?> rectangleClass = rectangle.getClass();

        Field widthField = rectangleClass.getDeclaredField("width");
        Field heightField = rectangleClass.getDeclaredField("height");

        widthField.setAccessible(true);
        heightField.setAccessible(true);

        rectangle.print();

        widthField.set(rectangle, 5);
        heightField.set(rectangle, 23);

        rectangle.print();
        System.out.println("Площадь равна: " + rectangle.square());
        Method perimeter = rectangleClass.getDeclaredMethod("perimeter");
        perimeter.setAccessible(true);
        System.out.println("Периметр равен: " + perimeter.invoke(rectangle));

        Method scale = rectangleClass.getDeclaredMethod("scale", int.class);
        scale.setAccessible(true);
        scale.invoke(rectangle,2);
        rectangle.print();

    }
}
