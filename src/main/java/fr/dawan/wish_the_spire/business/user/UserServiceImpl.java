package fr.dawan.wish_the_spire.business.user;

import fr.dawan.wish_the_spire.business.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, UserRepository, UserDto, UserMapper> implements UserService {

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {super(repository, mapper); }
}