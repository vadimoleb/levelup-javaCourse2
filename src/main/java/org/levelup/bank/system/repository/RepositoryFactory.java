package org.levelup.bank.system.repository;

import org.levelup.bank.system.config.HibernateConfiguration;
import org.levelup.bank.system.utils.TimedAnnotationInvocationHandler;

import java.lang.reflect.Proxy;

public class RepositoryFactory {

    public static AccountRepository getAccountRepository(boolean isJdbc, boolean buildProxy){
        if (buildProxy) {
            //создаем прокси
            return buildProxy(isJdbc);
        }
        return isJdbc ?
                new JdbcAccountRepository() :
                new HbmAccountRepository(HibernateConfiguration.getFactory());
    }

    private static AccountRepository buildProxy(boolean isJdbc){
        AccountRepository accountRepository = isJdbc ?
                new JdbcAccountRepository() :
                new HbmAccountRepository(HibernateConfiguration.getFactory());
        return (AccountRepository) Proxy.newProxyInstance(
                accountRepository.getClass().getClassLoader(),
                accountRepository.getClass().getInterfaces(),
                new TimedAnnotationInvocationHandler(accountRepository)
        );
    }
}
