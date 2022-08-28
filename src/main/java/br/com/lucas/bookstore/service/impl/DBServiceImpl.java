package br.com.lucas.bookstore.service.impl;

import br.com.lucas.bookstore.enums.RoleName;
import br.com.lucas.bookstore.model.Admin;
import br.com.lucas.bookstore.model.Role;
import br.com.lucas.bookstore.repository.AdminRepository;
import br.com.lucas.bookstore.repository.RoleRepository;
import br.com.lucas.bookstore.repository.UserRepository;
import br.com.lucas.bookstore.service.AdminService;
import br.com.lucas.bookstore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import static java.lang.System.out;


@Service
public class DBServiceImpl implements DBService {
    @Value("${api.profiles.images.profile}")
    private String image;
    @Autowired
    private RoleRepository roleRepositoy;
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserRepository userRepositoy;
    @Autowired
    private AdminRepository adminRepositoy;

;


    @Override
    public void instantiateDatabase() {
        try {
            if (roleRepositoy.count()<1){
                this.createRole();

            }
            if(userRepositoy.count()<1){
                this.createUser();
            }
        }catch (Exception e){
            out.println("ERRO Instante DB:"+e.getMessage());
        }




    }


    @Override
    public void createRole() {
        out.println("-Create role....");
        for (RoleName profile : RoleName.values()) {
            var role = new Role();
            role.setNomeRole(profile.name());
            roleRepositoy.save(role);
            out.println("\n new Role:"+profile.name());

        }
        out.println("\nCreate end role-");
    }

    @Override
    public void createUser() {
        out.println("-Create user....");

        var admin = new Admin("lucasDev@email.com","senha123456789","admin","dev",this.image);

        adminService.save(admin);

        out.println("\nCreate end user-");

    }


}
