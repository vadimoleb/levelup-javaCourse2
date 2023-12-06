package org.levelup.threads.producers;

public interface Queue<T> {

    void putTask(T task) throws InterruptedException;

    T takeTask() throws InterruptedException;


    int size();
}
