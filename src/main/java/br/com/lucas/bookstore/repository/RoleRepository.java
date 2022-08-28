package br.com.lucas.bookstore.repository;

import br.com.lucas.bookstore.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>, PagingAndSortingRepository<Role,Integer> {
    Role findBynameRole(String nameRole);


}
