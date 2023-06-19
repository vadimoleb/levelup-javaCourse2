package org.levelup.bank.system.repository;

import org.levelup.bank.system.utils.TimedAnnotationInvocationHandler;

import java.lang.reflect.Proxy;

public class JdbcRepositoryFactory {

    public static AccountRepository getAccountRepository( boolean buildProxy){
        if (buildProxy) {
            //создаем прокси
            return buildProxy();
        }
        return new JdbcAccountRepository();
    }

    private static AccountRepository buildProxy(){
        AccountRepository accountRepository = new JdbcAccountRepository();
        return (AccountRepository) Proxy.newProxyInstance(
                accountRepository.getClass().getClassLoader(),
                accountRepository.getClass().getInterfaces(),
                new TimedAnnotationInvocationHandler(accountRepository)
        );
    }
}
