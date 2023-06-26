package org.levelup.threads.producers;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class Downloader implements Runnable {

    private final Queue<String> queue;

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                String task = UUID.randomUUID().toString().substring(0, 10);
                System.out.println(Thread.currentThread().getName() + " downloader file with UUID " + task);
                queue.putTask(task);

                Thread.sleep(100);
            }
        } catch (InterruptedException ignored) {}
        ;

    }
}
