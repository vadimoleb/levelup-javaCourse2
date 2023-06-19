package org.levelup.bank.system.action;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.levelup.bank.system.domain.Client;
import org.levelup.bank.system.menu.ConsoleMenu;
import org.levelup.bank.system.repository.ClientRepository;


@RequiredArgsConstructor
public class ClientEditAction implements ConsoleAction{

    private final ClientRepository clientRepository;

    @Override
    public void doAction() {
        int clientId = ConsoleMenu.readLong("Введите идентификатор").intValue();
        String fio = ConsoleMenu.readString("Введите ФИО");
        String phone = ConsoleMenu.readString("Введите телефон");

        Client updateClient = clientRepository.edit(clientId,fio,phone);
        System.out.println(updateClient);
    }
}
