package org.levelup.bank.system;

import org.levelup.bank.system.action.AccountCreationAction;
import org.levelup.bank.system.action.AccountListingAction;
import org.levelup.bank.system.action.ConsoleAction;
import org.levelup.bank.system.action.ConsoleActionFactory;
import org.levelup.bank.system.config.ApplicationRunner;
import org.levelup.bank.system.menu.ConsoleMenu;

public class BankSystemApplication {

    public static void main(String[] args) {
        ApplicationRunner.runApp();

        Long command = null;
        do {
            ConsoleMenu.printGeneralMenu();
            command = ConsoleMenu.readLong("Введите номер команды");
            ConsoleAction action = ConsoleActionFactory.findAction(command);
            if (action != null){
                action.doAction();
            } else {
                System.out.println("Вы ввели неправильный номер команды");
            }
        } while (command == null || command != 0 );

    }


}
