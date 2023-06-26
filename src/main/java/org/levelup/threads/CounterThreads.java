package org.levelup.threads;

import lombok.RequiredArgsConstructor;

public class CounterThreads {
    public static void main(String[] args) throws InterruptedException {
        Counter sharedCounter = new Counter();

        //t0 -> sc(123abc)
        //t1 -> sc(123abc)
        //смотрят в одну область памяти
        Thread t0 = new Thread(new CounterRunnable(sharedCounter));
        Thread t1 = new Thread(new CounterRunnable(sharedCounter));
        Thread t2 = new Thread(new CounterRunnable(sharedCounter));

        t0.start();
        t1.start();
        t2.start();

        t0.join(); //заставляет поток мейн ожидать пока выполниться поток t0
        t1.join();
        t2.join();

        System.out.println(sharedCounter.getValue());

    }

    private static class Counter {

        private final Object mutex = new Object();

        private int value;

        public void increment() {
            synchronized (mutex){
                value++;
            }
        }

        public int getValue() {
            return value;
        }

        public Object getMutex(){
            return mutex;
        }
    }

    @RequiredArgsConstructor
    private static class CounterRunnable implements Runnable {

        private final Counter counter;

        @Override
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    //System.out.println(Thread.currentThread().getName() + ": " + counter.getValue());
                    counter.increment();
                    Thread.sleep(200);
                }
            }catch (InterruptedException ignored) {}
        }
    }
}
