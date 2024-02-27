package fr.dawan.wish_the_spire.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final AuthService service;

    @PostMapping("register")
    void register(@RequestBody RegisterDto dto){
        service.register(dto);
    }

    @PostMapping("login")
    LoginResponseDto login (@RequestBody LoginDto dto) throws Exception{
        return service.login(dto);
    }
}
