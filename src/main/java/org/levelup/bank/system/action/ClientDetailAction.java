package org.levelup.bank.system.action;

import lombok.RequiredArgsConstructor;
import org.levelup.bank.system.domain.Client;
import org.levelup.bank.system.menu.ConsoleMenu;
import org.levelup.bank.system.repository.ClientRepository;

@RequiredArgsConstructor
public class ClientDetailAction implements ConsoleAction{

    private final ClientRepository clientRepository;

    @Override
    public void doAction() {
        int clientId = ConsoleMenu.readLong("Введите идентификатор пользователя").intValue();
        Client client = clientRepository.findById(clientId);
        if (client != null) {
            System.out.println(client);
        }
        else {
            System.out.println("Пользователь не найден");
        }

    }
}
