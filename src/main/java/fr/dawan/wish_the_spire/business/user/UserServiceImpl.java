package fr.dawan.wish_the_spire.business.user;

import fr.dawan.wish_the_spire.business.generic.GenericServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, UserRepository, UserDto, UserMapper> implements UserService, UserDetailsService {

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {super(repository, mapper); }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + " introuvable"));
    }
}