package org.levelup.bank.system.action;

import org.levelup.bank.system.repository.AccountRepository;
import org.levelup.bank.system.repository.JdbcRepositoryFactory;

import java.util.HashMap;
import java.util.Map;

public class ConsoleActionFactory {

    private static final Map<Long, ConsoleAction> CONSOLE_ACTION_MAP = new HashMap();


    private static final boolean USE_JDBC = true;


    //блок инициалиации. скобки внутри класса. без названия. Отрабатываются ДО ВЫЗОВА КОНСТРУКТОРА.
    //static блок инициализируется при старте приложения один раз
    static {
        AccountRepository accountRepository = JdbcRepositoryFactory.getAccountRepository(true);
        CONSOLE_ACTION_MAP.put(1L, new AccountListingAction(accountRepository));
        CONSOLE_ACTION_MAP.put(2L, new AccountCreationAction());
        CONSOLE_ACTION_MAP.put(3L, new AccountEditNumberAction());
        CONSOLE_ACTION_MAP.put(4L, new AccountDeleteAction());
    }

    private ConsoleActionFactory() {
    }

    public static ConsoleAction findAction(Long command) {
        if (command == null) {
            return null;
        }
        return CONSOLE_ACTION_MAP.get(command);
    }
}
