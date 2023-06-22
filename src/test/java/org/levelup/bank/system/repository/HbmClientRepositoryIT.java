package org.levelup.bank.system.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.levelup.bank.system.config.DatabaseConfiguration;
import org.levelup.bank.system.config.HibernateConfiguration;
import org.levelup.bank.system.domain.Client;

import java.util.List;

public class HbmClientRepositoryIT {

    private static SessionFactory integrationTestFactory;

    private ClientRepository clientRepository = new HbmClientRepository(integrationTestFactory);

    @BeforeAll
    public static void startDatabase(){
        DatabaseConfiguration dbConfig = DatabaseConfiguration.getInstance();

        dbConfig.setUrl("jdbc:postgresql://localhost:5432/bank-system-test");
        dbConfig.setUsername("postgres");
        dbConfig.setPassword("postgres");
        dbConfig.setSchemaManagement("create");

        HibernateConfiguration.configure(dbConfig);
        integrationTestFactory = HibernateConfiguration.getFactory();
    }

    @Test
    public void shouldReturnExistingClientByClientId(){
        Client client = new Client();
        client.setFio("client_fio");
        client.setPhone("client_phone");

        try (Session session = integrationTestFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        }
        Client result = clientRepository.findById(client.getId());

        Assertions.assertEquals(client,result);
    }

    @Test
    public void shouldFindAllClients(){
        Client client = new Client();
        client.setFio("client_fio");
        client.setPhone("client_phone");

        try (Session session = integrationTestFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        }
        //when
        List<Client> result = clientRepository.findAll();

        //then
        Assertions.assertTrue(result.size()>=1);
        Assertions.assertTrue(result.contains(client));
    }


}
