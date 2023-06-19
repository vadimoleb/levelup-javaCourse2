package org.levelup.bank.system.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.levelup.bank.system.domain.Client;

import java.util.List;

@RequiredArgsConstructor
public class HbmClientRepository implements ClientRepository {

    private final SessionFactory factory;

    @Override
    public List<Client> findAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("from Client",Client.class)
                    .getResultList();
        }

    }

    @Override
    public Client findById(int clientId) {
        try (Session session = factory.openSession()){
            return session.get(Client.class, clientId);

        }
    }

    @Override
    public Client edit(int clientId, String fio, String phone) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Client client = session.get(Client.class, clientId);
            if (client == null) {
                throw new RuntimeException("Client with id "+clientId+" not found");
            }
            client.setFio(fio);
            client.setPhone(phone);

            tx.commit();
            return client;
        }
    }
}
