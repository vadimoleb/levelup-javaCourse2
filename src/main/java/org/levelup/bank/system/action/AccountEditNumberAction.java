package org.levelup.bank.system.action;

import org.levelup.bank.system.domain.Account;
import org.levelup.bank.system.menu.ConsoleMenu;
import org.levelup.bank.system.repository.AccountRepository;
import org.levelup.bank.system.repository.JdbcAccountRepository;

public class AccountEditNumberAction implements ConsoleAction {
    private final AccountRepository accountRepository;

    public AccountEditNumberAction(){this.accountRepository = new JdbcAccountRepository();}

    @Override
    public void doAction() {
        System.out.println("-------------");
        Long accountId = ConsoleMenu.readLong("Введите идентификатор счета");
        String number = ConsoleMenu.readString("Введите новый номер счета");
        String regex = "[1-9][0-9]+";

        if (number.matches(regex) && number.length()>=5) {
            Account account = accountRepository.editAccountNumber(accountId,number);
            if (account!=null){
                System.out.println("Измененный счет");
                System.out.println(account);
            }
        } else {
            System.out.println("Неверное введен номер счета");
        }

    }
}
