package org.levelup.threads.producers;

public class QueueApp {

    //example
    //1. Download excel files
    //2. Convert excel files to txt
    //3. Import txt files into DB



    //1. Producers
    //2. Consumers
    public static void main(String[] args) {

        //Производители (Producers)
        //Потребители (Consumers)

        Queue<String> queue = new SynchronizedQueue<>(10);
        Thread downloader1 = new Thread(new Downloader(queue), "downloader-1");
        Thread downloader2 = new Thread(new Downloader(queue), "downloader-2");

        downloader1.start();
        downloader2.start();

        Thread converter1 = new Thread(new Converter(queue), "converter-1");
        Thread converter2 = new Thread(new Converter(queue), "converter-2");
        Thread converter3 = new Thread(new Converter(queue), "converter-3");
        Thread converter4 = new Thread(new Converter(queue), "converter-4");
        Thread converter5 = new Thread(new Converter(queue), "converter-5");
        Thread converter6 = new Thread(new Converter(queue), "converter-6");

        converter1.start();
        converter2.start();
    }
}
