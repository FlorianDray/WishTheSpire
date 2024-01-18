package fr.dawan.wish_the_spire.business.game.actors;

import fr.dawan.wish_the_spire.business.game.spell.Spell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;
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
    private int nbPiocheCarte; // mana du joueur
    private List<Spell> main; //  spell dans la main du joueur
    private List<Spell> deck; // liste des spells possédé du joueur
    private List<Spell> defausse; // liste de la defausse du joueur

    //methode pour piocher une main au debut de chaque tour
    public void draw(){
        Random random = new Random();
        int index;

        for (int i = 0; i< nbPiocheCarte; i++){
            if ((deck.size() == 0) && (defausse.size() > 0)){ // si deck vide, melange de la defausse dans le deck
                melangeDefausse();
            }


            if (deck.size() > 0) {
                index = random.nextInt(0,deck.size());
                main.add(deck.get(index));
                deck.remove(index);
            }


        }


    }

    // methode qui melange la defausse dans la pioche
    private void melangeDefausse() {
        deck.addAll(defausse);
        defausse.clear();
        System.out.println("melange de la defausse dans la pioche");
    }

    public void tourDeCombat(Entity enemy) {
        draw(); // pioche initial

        while ( mana > 0) {
            afficheMain();
            int recupSaisie = getRecupSaisie(); // recupere la saisie du joueur

            try {
                if ((mana - main.get(recupSaisie).getManaCost()) >= 0 ) {

                    activateSelectedSpell(enemy, recupSaisie); // activation du spell

                }else {
                    System.out.println("");
                    System.out.println("cout en mana trop elevé");
                }
            } catch (Exception e) {
                System.out.println("saisie invalide");
            }


        }
    }

    //methode d activation du spell selectionné
    private void activateSelectedSpell(Entity enemy, int recupSaisie) {
        main.get(recupSaisie).activate(this, enemy);

        substractMana(recupSaisie); // soustrait le cout en mana et affiche le reste

        mainToDefausse(recupSaisie); //ajout du spell de la main a la defausse
    }

    //methode qui soustrait le mana en fonction du spell choisie et affiche le mana restant
    private void substractMana(int recupSaisie) {
        mana -= main.get(recupSaisie).getManaCost();

        System.out.println("");
        System.out.println("mana restant : " + mana);
    }

    // methode d ajout d un spell en main a la defausse
    private void mainToDefausse(int recupSaisie) {
        defausse.add(main.get(recupSaisie));
        main.remove(recupSaisie);
    }

    //methode de recuperation de la saisie utilisateur (INT)
    private static int getRecupSaisie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("choisissez votre spell");

        int recupSaisie = scanner.nextInt();
        return recupSaisie;
    }

    //methode qui affiche les cartes dans la main du joueur
    public void afficheMain() {
        main.forEach(s -> System.out.println("- " + s.getDescription()));
    }
}
