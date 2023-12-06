package org.levelup.threads.producers;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Converter implements Runnable{

    private final Queue<String> queue;

    //flag -> false
    //flag -> true && queue.size == 0 -> stop thread

    // !flag || queue.size !=0

    @Override
    public void run() {
        boolean interruptionFlag = false;

        try{
            while(!interruptionFlag || queue.size()!=0) {
                String task = queue.takeTask();
                System.out.println(Thread.currentThread().getName() + " got file from queue: " + task);
                Thread.sleep(200);
            }

        }catch (InterruptedException exc) {
            interruptionFlag = true;
        }
    }
}
