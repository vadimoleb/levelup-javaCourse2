package org.levelup.bank.system.action;

import org.levelup.bank.system.config.HibernateConfiguration;
import org.levelup.bank.system.domain.Account;
import org.levelup.bank.system.menu.ConsoleMenu;
import org.levelup.bank.system.repository.AccountRepository;
import org.levelup.bank.system.repository.HbmAccountRepository;
import org.levelup.bank.system.repository.JdbcAccountRepository;

public class AccountCreationAction implements ConsoleAction{

    private final AccountRepository accountRepository;

    public AccountCreationAction() {

        //this.accountRepository = new JdbcAccountRepository();
        this.accountRepository = new HbmAccountRepository(HibernateConfiguration.getFactory());
    }

    @Override
    public void doAction() {
        System.out.println("-------------");
        String number = ConsoleMenu.readString("Введите номер счета");
        String currency = ConsoleMenu.readString("Введите валюту");
        Integer clientId = ConsoleMenu.readInteger("Введите идентификатор клиента");

        Account account = accountRepository.createAccount(number, currency, clientId);

        System.out.println("Добавленный счет");
        System.out.println(account);
    }
}
