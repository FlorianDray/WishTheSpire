package fr.dawan.wish_the_spire.security.auth;

public interface AuthService {

    void register(RegisterDto dto);
    LoginResponseDto login (LoginDto dto) throws Exception;
}
