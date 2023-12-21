package fr.dawan.wish_the_spire.business.user;

import fr.dawan.wish_the_spire.business.generic.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    private String username;
    private String email;
    private String password;
}