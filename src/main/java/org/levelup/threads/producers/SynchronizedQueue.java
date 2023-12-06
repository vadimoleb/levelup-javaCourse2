package org.levelup.threads.producers;

import java.util.LinkedList;

public class SynchronizedQueue<T> implements Queue<T> {

    private final LinkedList<T> queue = new LinkedList<>();
    private final int capacity;

    public SynchronizedQueue(int capacity) {
        this.capacity = capacity;
    }

    private final Object readMutex = new Object();
    private final Object writeMutex = new Object();


    @Override
    public void putTask(T task) throws InterruptedException {

        //1. Если очередь заполнена то надо заблокировать запись
        //2. Если очередь пуста то надо заблокировать чтение
        synchronized (readMutex){
            while (queue.size()==capacity) {
                //когда очередь заполнена
                System.out.println(Thread.currentThread().getName() + " is waiting");
                readMutex.wait();
            }
        }

        synchronized (writeMutex) {
            queue.add(task);
            writeMutex.notifyAll();
        }

    }

    @Override
    public T takeTask() throws InterruptedException {
        synchronized (writeMutex){
            while (queue.isEmpty()){
                writeMutex.wait();
            }
        }


        synchronized (readMutex) {
           T task = queue.poll();
           readMutex.notifyAll(); //выводит поток из режима ожидания
           return task;
        }
    }

    public int size(){
        synchronized (readMutex){
            return queue.size();
        }
    }
}
