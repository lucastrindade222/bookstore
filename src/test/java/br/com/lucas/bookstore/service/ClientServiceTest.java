package br.com.lucas.bookstore.service;

import br.com.lucas.bookstore.config.AplicationConfingTest;
import br.com.lucas.bookstore.enums.RoleName;
import br.com.lucas.bookstore.model.Client;
import br.com.lucas.bookstore.model.Role;
import br.com.lucas.bookstore.repository.ClientRepository;
import br.com.lucas.bookstore.repository.RoleRepository;
import br.com.lucas.bookstore.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;


@DisplayName("ClientServiceImpl")
public class ClientServiceTest extends AplicationConfingTest {

    @Value("${api.profiles.images.profile}")
    private String url;
 ;
    @MockBean
    private ClientRepository clientRepositoy;
    @MockBean
    private RoleRepository roleRepositoy;
    @Autowired
    private ClientService clientService;



    @Test
    public void save(){
        var cliente = new Client(  "lucasDevJava@email.com", "password123","nome",url);
        cliente = clientService.save(cliente);

        Assertions.assertNotNull(cliente.getId(),"Id nulo");

    }


    @BeforeEach
    public void setup() {
        var cliente = new Client(  "lucas@email.com", "password123","nome",url);
        Mockito.when(clientRepositoy.findByEmail(cliente.getEmail())).thenReturn(cliente);

        var role = new Role();
        role.setNomeRole(RoleName.ROLE_CLIENTE.name());
        Mockito.when(roleRepositoy.findBynameRole(RoleName.ROLE_CLIENTE.name())).thenReturn(role);
    }


}

