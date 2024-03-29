package fr.dawan.wish_the_spire.business.game.spell;

import fr.dawan.wish_the_spire.business.game.effect.Effect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpellDto {
    private int manaCost ; // cout en mana du spell
    private String description; // description du spell
    private List<Effect> effects; // liste des effets a appliquer
}
