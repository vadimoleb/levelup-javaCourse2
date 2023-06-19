package org.levelup.bank.system.repository;

import org.levelup.bank.system.domain.Client;

import java.util.List;

public interface ClientRepository {

    List<Client> findAll();

    Client findById(int clientId);

    Client edit(int clientId, String fio, String phone);
}
