package fr.dawan.wish_the_spire.security.auth;


import fr.dawan.wish_the_spire.business.user.User;
import fr.dawan.wish_the_spire.business.user.UserMapper;
import fr.dawan.wish_the_spire.business.user.UserRepository;
import fr.dawan.wish_the_spire.security.tools.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final UserMapper mapper;

    @Override
    public void register(RegisterDto dto) {
        String encodedPassword = encoder.encode(dto.getPassword());
        User newUser = new User(dto.getUsername(),encodedPassword,dto.getEmail());
        repository.save(newUser);
    }

    @Override
    public LoginResponseDto login(LoginDto dto) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getPassword(), new ArrayList<>()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getEmail());
        String token = JwtUtils.generateToken(userDetails);
        return new LoginResponseDto(mapper.toDto((User) userDetails),token);
    }
}