package fr.dawan.wish_the_spire.business.game.actors;

import fr.dawan.wish_the_spire.business.game.spell.Spell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Scanner;

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

    public void tourDeCombat(Entity enemy) {
        while ( mana > 0) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("choisissez votre spell");
            int recupSaisie = scanner.nextInt();

            try {
                if ((mana - spellList.get(recupSaisie).getManaCost()) >= 0 ) {

                        spellList.get(recupSaisie).activate(this, enemy);
                        mana -= spellList.get(recupSaisie).getManaCost();
                        System.out.println("mana restant : " + mana);

                }else {
                    System.out.println("cout en mana trop elevé");
                }
            } catch (Exception e) {
                System.out.println("saisie invalide");
            }


        }
    }
}
