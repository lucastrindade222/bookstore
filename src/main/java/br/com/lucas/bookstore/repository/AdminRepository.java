package br.com.lucas.bookstore.repository;

import br.com.lucas.bookstore.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AdminRepository  extends JpaRepository<Admin, UUID>,PagingAndSortingRepository<Admin,UUID>{
    Admin findByEmail(String email);
}
