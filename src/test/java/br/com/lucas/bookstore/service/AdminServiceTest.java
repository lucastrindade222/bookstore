package br.com.lucas.bookstore.service;

import br.com.lucas.bookstore.config.AplicationConfingTest;
import br.com.lucas.bookstore.enums.RoleName;
import br.com.lucas.bookstore.model.Admin;
import br.com.lucas.bookstore.model.Role;
import br.com.lucas.bookstore.repository.AdminRepository;
import br.com.lucas.bookstore.repository.RoleRepository;
import br.com.lucas.bookstore.service.impl.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;

@DisplayName("AdminServiceImpl")
public class AdminServiceTest extends AplicationConfingTest {


    @Value("${api.profiles.images.profile}")
    private String url;

    @MockBean
    private AdminRepository adminRepository;
    @MockBean
    private RoleService roleService;
    @MockBean
    private RoleRepository roleRepositoy;
    @Autowired
    private AdminService adminService;

    @Test
    public void save(){

        var admin = new Admin("admin@email.com","123456","admin","teste",url);

        adminService.save(admin);


    }


    @BeforeEach
    public void setup() {


        var role = new Role();
        role.setNomeRole(RoleName.ROLE_ADMIN.name());
        Mockito.when(roleRepositoy.findBynameRole(RoleName.ROLE_CLIENTE.name())).thenReturn(role);
    }
}
