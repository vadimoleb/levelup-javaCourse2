package org.levelup.threads;

public class ThreadInterruption {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Printer());
        t.start();
        t.interrupt();
        Thread.sleep(2000);
        t.interrupt();

    }

    private static class Printer implements Runnable {


        @Override
        public void run() {

            // t.interrupt()  --> генерирует флаг прерывания делает его true
            // t.isInterrupted --> boolean
            // Thread.interrupted --> boolean --> false

            int counter = 0;
            boolean shutdown = false;
            int shutdownCount = 0;
            while (!shutdown) {
                if (counter % 1_000_000 == 0) {
                    System.out.println("Counter value " + counter);
                }
                counter++;

                if (Thread.interrupted()) {
                    shutdownCount++;
                    if (shutdownCount >= 2) {
                        shutdown = true;
                    }
                }

            }
        }
    }
}
