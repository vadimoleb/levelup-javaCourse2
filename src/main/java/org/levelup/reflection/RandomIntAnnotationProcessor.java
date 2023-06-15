package org.levelup.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Random;

public class RandomIntAnnotationProcessor {
    public Point processAnnotations() {
        //1. Получить объект класса Class
        //2. Создать объект класса Point
        //3. Найти аннотации RandomInt и установить значения полей

        Class<?> pointClass = Point.class;
        try{
            Constructor<?> defaultConstructor = pointClass.getDeclaredConstructor();
            defaultConstructor.setAccessible(true);
            Point pointObject = (Point) defaultConstructor.newInstance();

            Field[] fields = pointClass.getDeclaredFields();
            for (Field field : fields) {
               RandomInt annotationObject =  field.getAnnotation(RandomInt.class);
               if (annotationObject != null){
                   // получить min/max
                   int min = annotationObject.min();
                   int max = annotationObject.max();

                   Random rnd = new Random();
                   int value = rnd.nextInt(max - min) + min;
                   field.setAccessible(true);
                   field.set(pointObject, value);
               }
            }

            return pointObject;
        } catch (Exception exc) {
            throw new RuntimeException();
        }

    }


    public <T> T processAnnotationsAndCreateObject(Class<T> tClass) {


        try{
            Constructor<?> defaultConstructor = tClass.getDeclaredConstructor();
            defaultConstructor.setAccessible(true);
            T tObject = (T) defaultConstructor.newInstance();

            Field[] fields = tClass.getDeclaredFields();
            for (Field field : fields) {
                RandomInt annotationObject =  field.getAnnotation(RandomInt.class);
                if (annotationObject != null){
                    // получить min/max
                    int min = annotationObject.min();
                    int max = annotationObject.max();

                    Random rnd = new Random();
                    int value = rnd.nextInt(max - min) + min;
                    field.setAccessible(true);
                    field.set(tObject, value);
                }
            }

            return tObject;
        } catch (Exception exc) {
            throw new RuntimeException();
        }

    }
}
