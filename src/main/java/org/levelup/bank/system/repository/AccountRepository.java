package org.levelup.bank.system.repository;

import org.levelup.bank.system.domain.Account;

import java.util.Collection;

public interface AccountRepository {

    Collection<Account> findUserAccounts(long userId);

    Account createAccount(String number, String currency, long clientId);

}
