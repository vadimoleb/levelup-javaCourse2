package org.levelup.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionApp {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //Получение объекта класса Class
        // 1. Используя объект класса
        Point point = new Point(5,7);
        Class<?> classOfPoint = point.getClass();

        //2. Используя литерал class
        Class<?> pointClass = Point.class;

        //Получить объект, представляющий собой поле у в классе Point
        Field yField = pointClass.getField("y");

        int yValue = (int) yField.get(point);

        System.out.println("y value = "+yValue);

        Class<?> yFieldType = yField.getType();
        System.out.println("is y type primitive? "+yFieldType.isPrimitive());

        yField.set(point, 10);
        System.out.println("y value "+point.y);

        //получить приватные и неприватные поля
        Field xField = pointClass.getDeclaredField("x");
        //отключение проверок на модификатор доступа
        xField.setAccessible(true);
        System.out.println("x value "+xField.get(point));


        Constructor<?> withoutParams = pointClass.getDeclaredConstructor(); // Point() {}
        Constructor<?> withAllParams = pointClass.getDeclaredConstructor(int.class, int.class); //Point (int x, int y){}
        Constructor<?> withOneParams = pointClass.getDeclaredConstructor(int.class); //Point(int x)

        withoutParams.setAccessible(true);
        Point pointPrivateConstructor = (Point) withoutParams.newInstance();
        pointPrivateConstructor.print();

        Point p1 = (Point) withOneParams.newInstance(9);
        Point p2 = (Point) withAllParams.newInstance(3,2);

        p1.print();
        p2.print();

        Method m = pointClass.getDeclaredMethod("changeYValue", int.class);
        m.setAccessible(true);
        m.invoke(p1,1);
        p1.print();

    }
}
