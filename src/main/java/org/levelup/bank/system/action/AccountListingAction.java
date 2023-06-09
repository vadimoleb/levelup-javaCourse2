package org.levelup.bank.system.action;

import org.levelup.bank.system.domain.Account;
import org.levelup.bank.system.menu.ConsoleMenu;
import org.levelup.bank.system.repository.AccountRepository;

import java.util.Collection;

public class AccountListingAction implements ConsoleAction {

    private final AccountRepository accountRepository;

    public AccountListingAction(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void doAction() {
        // показать список счетов пользователей
        // получить ид пользователя
        Integer userId = ConsoleMenu.readInteger("Введите идентификатор пользователя: ");
        if (userId == null) {
            System.out.println("Некорректный идентификатор");
            return;
        }
        //делаем запрос в бд и получаем список счетов пользователя
        Collection<Account> accounts = accountRepository.findUserAccounts(userId);

        //выведем список счетов
        for (Account account : accounts) {
            System.out.println(account);
        }

    }
}
