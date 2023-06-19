package org.levelup.bank.system.repository;

import org.levelup.bank.system.domain.Account;
import org.levelup.bank.system.utils.Timed;

import java.util.Collection;

public interface AccountRepository {

    @Timed
    Collection<Account> findUserAccounts(int userId);

    Account createAccount(String number, String currency, int clientId);
    Account editAccountNumber(long accountId, String number);
    Boolean deleteAccount(long accountId, long clientId);

}
