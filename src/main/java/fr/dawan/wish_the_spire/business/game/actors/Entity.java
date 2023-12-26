package fr.dawan.wish_the_spire.business.game.actors;

import fr.dawan.wish_the_spire.business.game.spell.Spell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity {
    private int pv; // point de vie du joueur
    private int force; // point de force s ajoutant au degat
    private int dexterite; // point de dexterite s ajoutant a l armure
    private int armure; // point d armure
    private int mana; // mana du joueur
    private List<Spell> spellList; // liste des spells possédé du joueur

    void tourDeCombat(Entity enemy) {
        while ( mana < 0) {

        }
    }
}
