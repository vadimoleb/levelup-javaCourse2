package org.levelup.bank.system.action;


import lombok.RequiredArgsConstructor;
import org.levelup.bank.system.domain.Client;
import org.levelup.bank.system.repository.ClientRepository;

import java.util.List;

@RequiredArgsConstructor
public class ClientListingAction implements ConsoleAction{


    private final ClientRepository clientRepository;
    @Override
    public void doAction() {
        List<Client> clients = clientRepository.findAll();

        System.out.println("Список пользователей: ");
        for (Client client: clients
             ) {
            System.out.println(client);
        }
    }
}
