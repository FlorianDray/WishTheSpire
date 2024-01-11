package fr.dawan.wish_the_spire.business.game.spell;

import fr.dawan.wish_the_spire.business.game.actors.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spell {
    private int manaCost ; // cout en mana du spell
    private String description; // description du spell
    private List<Effect> effects; // liste des effets a appliquer

    public void activate(Entity caster, Entity target) { // activation du spell

        effects.forEach((effet) -> effet.activateEffect(caster, target));
    }
}