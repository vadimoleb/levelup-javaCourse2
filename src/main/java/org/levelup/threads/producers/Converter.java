package org.levelup.threads.producers;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Converter implements Runnable{

    private final Queue<String> queue;

    @Override
    public void run() {
        try{
            while(true) {
                String task = queue.takeTask();
                System.out.println(Thread.currentThread().getName() + " got file from queue: " + task);
                Thread.sleep(200);
            }
        }catch (InterruptedException ignored) {}
    }
}
