package org.levelup.threads;

public class ThreadsExample {
    public static void main(String[] args){

        println("I'm in main thread");
        //1. extends Thread
        //2. implements Runnable
        //3. implements Callable (but starts only through thread pool
        PrinterThread printerThread = new PrinterThread();
        printerThread.start(); //создание потока и его запуск
        //printerThread.run() =>> //поток не создаться, код просто используется.

        Thread runnableThread = new Thread(new PrinterRunnable(),"PrinterRunnable"); //название потока

        runnableThread.setDaemon(true); //демон-поток
        runnableThread.start();

        println("the End");
    }
    static class PrinterThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {
                System.out.println("KILLED");
            }
            //что будет делать поток.
            println("I'm in PrinterThread");
        }
    }

    static class PrinterRunnable implements Runnable{

        @Override
        public void run() {
            println("I'm in PrinterRunnable");
        }
    }



    static void println(String value){
        System.out.println(Thread.currentThread().getName() +": "+value);
    }
}
