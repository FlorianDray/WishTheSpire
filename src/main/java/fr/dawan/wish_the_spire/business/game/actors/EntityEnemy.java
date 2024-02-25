package fr.dawan.wish_the_spire.business.game.actors;

import fr.dawan.wish_the_spire.business.game.spell.Spell;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EntityEnemy extends Entity{
    public EntityEnemy(int pv, int force, int dexterite, int armure, int mana, int manaMax, int nbPiocheCarte, List<Spell> main, List<Spell> deck, List<Spell> defausse) {
        super(pv, force, dexterite, armure, mana, manaMax, nbPiocheCarte, main, deck, defausse);
    }


    public void tourDeCombat(Entity player){
        draw(); // pioche initial

        while (getMain().size() > 0){
            this.activateSelectedSpell(player, 0);
        }
        System.out.println("pv du joueur : " + player.getPv() + "\n");
        System.out.println("pv de l enemie : " + this.getPv() + "\n");

    }

    @Override
    public void activateSelectedSpell(Entity player, int recupSaisie){
        getMain().get(recupSaisie).activate(this, player);
        System.out.println(getMain().get(recupSaisie).getDescription());

        mainToDefausse(recupSaisie);

    }


}
