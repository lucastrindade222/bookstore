package br.com.lucas.bookstore.resource;

import br.com.lucas.bookstore.dto.AdminNewDTO;
import br.com.lucas.bookstore.model.Admin;
import br.com.lucas.bookstore.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("admin")
public class AdminResource {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> save(@Validated @RequestBody AdminNewDTO adminNewDTO){
      var admin = modelMapper.map(adminNewDTO, Admin.class);
      admin = adminService.save(admin);
      return ResponseEntity.status(HttpStatus.CREATED).body(admin);
    }


}

