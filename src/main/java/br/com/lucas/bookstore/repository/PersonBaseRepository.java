package br.com.lucas.bookstore.repository;

import br.com.lucas.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;


@NoRepositoryBean
public interface PersonBaseRepository<T extends User> extends JpaRepository<T, UUID> {

}