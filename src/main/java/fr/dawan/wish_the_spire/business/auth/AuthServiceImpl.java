package fr.dawan.wish_the_spire.business.auth;

import fr.dawan.wish_the_spire.business.user.User;
import fr.dawan.wish_the_spire.business.user.UserMapper;
import fr.dawan.wish_the_spire.business.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public void register(RegisterDto dto) {
        String encodedPassword = dto.getPassword(); // need method Encode
        User newUser = new User(dto.getUsername(), dto.getEmail(), encodedPassword);
        repository.save(newUser);
    }

    @Override
    public LoginResponseDto login(LoginDto dto) throws Exception {
        User existingUser = repository.findByEmail(dto.getEmail()).orElse(null);
        if(existingUser == null) throw new Exception("Utilisateur introuvable");
        String encodedPassword = dto.getPassword();// need method Encode
        if(!encodedPassword.equals(existingUser.getPassword())) throw new Exception("Mot de passe incorrecte");
        String token = "token";
        return new LoginResponseDto(mapper.toDto(existingUser), token);
    }
}
