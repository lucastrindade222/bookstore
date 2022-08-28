package br.com.lucas.bookstore.repository;

import br.com.lucas.bookstore.model.Client;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClientRepository extends PersonBaseRepository<Client> {
    public Client findByEmail(String email);
}
