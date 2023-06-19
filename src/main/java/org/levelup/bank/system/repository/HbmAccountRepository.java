package org.levelup.bank.system.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.levelup.bank.system.domain.Account;
import org.levelup.bank.system.domain.Client;

import java.math.BigInteger;
import java.util.Collection;

//конструктор с финал полями
@RequiredArgsConstructor
public class HbmAccountRepository implements AccountRepository{

    private final SessionFactory factory;

    @Override
    public Collection<Account> findUserAccounts(int userId) {
        try (Session session = factory.openSession()){
            //HQL . Оперируем полями классов
            //:userId = ? только заданный userId
            return session.createQuery("from Account where client.id = :userId", Account.class)
                    .setParameter("userId", userId)
                    .getResultList();
        }

    }

    @Override
    public Account createAccount(String number, String currency, int clientId) {
        try (Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            Long maxAccountId = ((BigInteger)session
                    .createNativeQuery("select max(account_id) from accounts")
                    .getSingleResult()).longValue();

            Client client = session.load(Client.class,clientId);
            Account account = new Account(maxAccountId + 1, number,currency, client);
            //создание записи
            session.persist(account);


            tx.commit();
            return account;
        }
    }

    @Override
    public Account editAccountNumber(long accountId, String number) {
        return null;
    }

    @Override
    public Boolean deleteAccount(long accountId, long clientId) {
        return null;
    }
}
