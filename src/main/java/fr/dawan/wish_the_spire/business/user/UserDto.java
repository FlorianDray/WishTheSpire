package fr.dawan.wish_the_spire.business.user;

import fr.dawan.wish_the_spire.business.generic.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {
    private long id;
    private int version;
    private String name;
}