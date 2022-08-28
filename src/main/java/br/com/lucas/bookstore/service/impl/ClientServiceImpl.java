package br.com.lucas.bookstore.service.impl;

import br.com.lucas.bookstore.model.Admin;
import br.com.lucas.bookstore.model.Client;
import br.com.lucas.bookstore.repository.ClientRepository;
import br.com.lucas.bookstore.repository.RoleRepository;
import br.com.lucas.bookstore.service.ClientService;
import br.com.lucas.bookstore.utils.UTILS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.lucas.bookstore.enums.RoleName.ROLE_CLIENTE;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private RoleService roleService;
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client save(Client client) {
        client = (Client)  UTILS.now().encryptPassword(client);
        var role=   roleService.findByName(ROLE_CLIENTE.name());
        client.setRole(role);
        return clientRepository.save(client);

    }
}
