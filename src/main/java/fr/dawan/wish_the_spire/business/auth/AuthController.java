package fr.dawan.wish_the_spire.business.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
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
