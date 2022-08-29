package br.com.lucas.bookstore.resource;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import br.com.lucas.bookstore.config.AplicationConfingTest;
import br.com.lucas.bookstore.dto.AdminNewDTO;
import br.com.lucas.bookstore.enums.RoleName;
import br.com.lucas.bookstore.model.Role;
import br.com.lucas.bookstore.repository.AdminRepository;
import br.com.lucas.bookstore.repository.RoleRepository;
import br.com.lucas.bookstore.service.AdminService;
import br.com.lucas.bookstore.service.impl.RoleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@DisplayName("AdminResource")
public class AdminResourceTest extends AplicationConfingTest {
    @MockBean
    private AdminRepository adminRepository;
    @MockBean
    private RoleService roleService;
    @MockBean
    private RoleRepository roleRepositoy;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSalva() throws JsonProcessingException, Exception {

        var admin = new AdminNewDTO("lucasDev@gmail.com","123456","lucas","silva");


        mockMvc.perform(post("/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(admin))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @BeforeEach
    public void setup() {


        var role = new Role();
        role.setNomeRole(RoleName.ROLE_ADMIN.name());
        Mockito.when(roleRepositoy.findBynameRole(RoleName.ROLE_CLIENTE.name())).thenReturn(role);
    }
}
