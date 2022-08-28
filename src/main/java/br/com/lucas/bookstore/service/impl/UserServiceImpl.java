package br.com.lucas.bookstore.service.impl;

import br.com.lucas.bookstore.repository.UserRepository;
import br.com.lucas.bookstore.service.UserService;
import br.com.lucas.bookstore.service.exception.UniqueFieldException;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void checkEmailExists(String email){
        var user = userRepository.findByEmail(email);

        if (user != null) {
            throw new UniqueFieldException("O e-mail já existe no sistema.");
        }

    }
}
