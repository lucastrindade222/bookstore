package br.com.lucas.bookstore.service.impl;

import br.com.lucas.bookstore.model.Role;
import br.com.lucas.bookstore.repository.RoleRepository;

import br.com.lucas.bookstore.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepositoy;

   public Role findByName(String name){

      Role role = roleRepositoy.findBynameRole(name);

      if(role == null){
          throw new ObjectNotFoundException("não encontrado");
      }

  return role;


   }


    public Role findById(Integer id) {
        Optional<Role> role = roleRepositoy.findById(id);
        return role.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " ));
    }




}
