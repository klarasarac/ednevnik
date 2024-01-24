package ba.sum.fsre.ednevnik.services;

import ba.sum.fsre.ednevnik.models.User;
import ba.sum.fsre.ednevnik.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public ba.sum.fsre.ednevnik.models.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repository.findByEmail(username);
        return new ba.sum.fsre.ednevnik.models.UserDetails(u);
    }
}
