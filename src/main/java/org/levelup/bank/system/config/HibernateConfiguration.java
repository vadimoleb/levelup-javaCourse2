package org.levelup.bank.system.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.levelup.bank.system.domain.Account;
import org.levelup.bank.system.domain.Client;
import org.postgresql.Driver;

import java.util.Properties;

public class HibernateConfiguration {

    private static SessionFactory factory;

    public static void configure(DatabaseConfiguration dbConfig){
        Properties dbProperties = new Properties();
        dbProperties.setProperty("hibernate.connection.url", dbConfig.getUrl());
        dbProperties.setProperty("hibernate.connection.username", dbConfig.getUsername());
        dbProperties.setProperty("hibernate.connection.password", dbConfig.getPassword());

        dbProperties.setProperty("hibernate.connection.driver_class", Driver.class.getName());
        dbProperties.setProperty("hibernate.show_sql", "true");
        dbProperties.setProperty("hibernate.format_sql", "true");

        //чо делать со схемой. в данном случае - валидация полей, которые используются по коду
        dbProperties.setProperty("hibernate.hbm2ddl.auto", "validate");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(dbProperties)
                .build();

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Client.class);
        factory = configuration.buildSessionFactory(registry);
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
