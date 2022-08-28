package br.com.lucas.bookstore.service.impl;




import br.com.lucas.bookstore.model.User;
import br.com.lucas.bookstore.repository.UserRepository;
import br.com.lucas.bookstore.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario não encontrado! "+email);
        }

        return new UserSS(user.getId(),user.getEmail(),user.getPassword(),user.getRoles());
    }





}
