package fr.dawan.wish_the_spire.business.auth;

import fr.dawan.wish_the_spire.business.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private UserDto user;
    private String token;
}
