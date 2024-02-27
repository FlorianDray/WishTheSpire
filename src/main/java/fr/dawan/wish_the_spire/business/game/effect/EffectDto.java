package fr.dawan.wish_the_spire.business.game.effect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EffectDto {
    private TypeEffect type;
    private int value;
    private long id;

}
