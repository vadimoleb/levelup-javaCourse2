package org.levelup.bank.system.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimedAnnotationInvocationHandler implements InvocationHandler {

    private final Object originalObject;

    public TimedAnnotationInvocationHandler(Object originalObject) {
        this.originalObject = originalObject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Timed annotation = method.getAnnotation(Timed.class);
        if (annotation != null) {
            //тут замеряем время выполнения метода
            long start = System.currentTimeMillis();
            Object result = method.invoke(originalObject, args); //вызов оригинального метода
            long end = System.currentTimeMillis();
            System.out.println("Время выполнения метода " + method.getName() + ": " + (end-start) + " мс");
            return result;
        }

        return method.invoke(originalObject, args);
    }
}
