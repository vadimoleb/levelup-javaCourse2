package org.levelup.bank.system.action;

import org.levelup.bank.system.domain.Account;
import org.levelup.bank.system.menu.ConsoleMenu;
import org.levelup.bank.system.repository.AccountRepository;
import org.levelup.bank.system.repository.JdbcAccountRepository;

public class AccountDeleteAction implements ConsoleAction{
    private final AccountRepository accountRepository;
    public AccountDeleteAction() {
        this.accountRepository = new JdbcAccountRepository();
    }

    @Override
    public void doAction(){
        System.out.println("-------------");
        Long accountId = ConsoleMenu.readLong("Введите идентификатор счета");
        Long clientId = ConsoleMenu.readLong("Введите идентификатор клиента");
        Boolean account = accountRepository.deleteAccount(accountId,clientId);
        if (account) {
            System.out.println("Счет удален");
        }

    }

}
