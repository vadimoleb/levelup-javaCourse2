package org.levelup.bank.system;

import org.levelup.bank.system.action.AccountCreationAction;
import org.levelup.bank.system.action.AccountListingAction;
import org.levelup.bank.system.menu.ConsoleMenu;

public class BankSystemApplication {

    public static void main(String[] args) {
        ConsoleMenu.printGeneralMenu();
        Long command = ConsoleMenu.readLong("Введите номер команды");
        if (command != null && command == 1){
            new AccountListingAction().doAction();
        } else if (command != null && command == 2) {
            new AccountCreationAction().doAction();
        } else {
            System.out.println("Вы ввели неправильный номер команды");
        }
    }


}
