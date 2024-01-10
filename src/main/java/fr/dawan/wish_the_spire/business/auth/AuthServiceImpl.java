package fr.dawan.wish_the_spire.business.auth;

import fr.dawan.wish_the_spire.business.user.User;
import fr.dawan.wish_the_spire.business.user.UserMapper;
import fr.dawan.wish_the_spire.business.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final UserMapper mapper;

    @Override
    public void register(RegisterDto dto) {
        String encodedPassword = encoder.encode(dto.getPassword());
        User newUser = new User(dto.getUsername(), dto.getEmail(), encodedPassword, "PUBLIC");
        repository.save(newUser);
    }

    @Override
    public LoginResponseDto login(LoginDto dto) throws Exception {
        User existingUser = repository.findByEmail(dto.getEmail()).orElse(null);
        if(existingUser == null) throw new Exception("Utilisateur introuvable");
        String encodedPassword = encoder.encode(dto.getPassword());
        if(!encodedPassword.equals(existingUser.getPassword())) throw new Exception("Mot de passe incorrecte");
        String token = "token";
        return new LoginResponseDto(mapper.toDto(existingUser), token);
    }
}
