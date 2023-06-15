package org.levelup.bank.system.config;

public class ApplicationRunner {
    public static void runApp(){
        PropertyAnnotationProcessor processor = new PropertyAnnotationProcessor();
        processor.process(DatabaseConfiguration.getInstance());
    }
}
