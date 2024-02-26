package fr.dawan.wish_the_spire.business.game.spell;

import fr.dawan.wish_the_spire.business.game.actors.Player;
import fr.dawan.wish_the_spire.business.generic.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@jakarta.persistence.Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spell extends BaseEntity {
    private int manaCost ; // cout en mana du spell
    private String description; // description du spell
    private List<Effect> effects; // liste des effets a appliquer

    public void activate(Player caster, Player target) { // activation du spell

        effects.forEach((effet) -> effet.activateEffect(caster, target));
    }
}
