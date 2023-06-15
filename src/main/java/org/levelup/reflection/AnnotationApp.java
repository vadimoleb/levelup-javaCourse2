package org.levelup.reflection;

import org.levelup.bank.system.action.ConsoleAction;
import org.levelup.bank.system.domain.Account;
import org.levelup.bank.system.menu.ConsoleMenu;

public class AnnotationApp {
    public static void main(String[] args) {
        RandomIntAnnotationProcessor processor = new RandomIntAnnotationProcessor();

        Point obj = processor.processAnnotations();
        obj.print();

        Account account = processor.processAnnotationsAndCreateObject(Account.class);
        Point point = processor.processAnnotationsAndCreateObject(Point.class);
        ConsoleMenu consoleMenu = processor.processAnnotationsAndCreateObject(ConsoleMenu.class);
    }
}
