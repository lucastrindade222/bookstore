package br.com.lucas.bookstore.service.impl;


import br.com.lucas.bookstore.model.Admin;
import br.com.lucas.bookstore.repository.AdminRepository;

import br.com.lucas.bookstore.service.AdminService;
import br.com.lucas.bookstore.utils.UTILS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import static br.com.lucas.bookstore.enums.RoleName.ROLE_ADMIN;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository repo;
    @Autowired
    private RoleService roleService;


    @Override
    public Admin save(Admin admin) {
        admin = (Admin)  UTILS.now().encryptPassword(admin);
      var role=   roleService.findByName(ROLE_ADMIN.name());
      admin.setRole(role);
      return repo.save(admin);
    }
}
