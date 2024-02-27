package fr.dawan.wish_the_spire.business.game.actors;

import fr.dawan.wish_the_spire.business.game.spell.Spell;
import fr.dawan.wish_the_spire.business.generic.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player extends BaseEntity {
    protected int pv; // point de vie du joueur
    protected int forcef; // point de force s ajoutant au degat
    protected int dexterite; // point de dexterite s ajoutant a l armure
    protected int armure; // point d armure
    protected int mana; // mana du joueur
    protected int manaMax; // mana maximum du joueur
    protected int nbPiocheCarte; // nb de carte que le joueur pioche par tour
   @Transient
    protected List<Spell> main; //  spell dans la main du joueur
    protected List<Spell> deck; // liste des spells possédé du joueur
    @Transient
    protected List<Spell> defausse; // liste de la defausse du joueur

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

    // methode qui rajoute toute la main a la defausse
    private void allMainToDefausse() {
        defausse.addAll(main);
        main.clear();
    }


    public void tourDeCombat(PlayerEnemy enemy) {

        while (enemy.getPv() > 0 || pv < 1) { //tant que l enemie ou lr joueur  n est pas mort


            if (armure != 0){
                armure = 0;
            }
            draw(); // pioche initial

            while (mana > 0 && enemy.getPv() > 0) { // tant que le joueur a du mana et que le mob est pas mort
                afficheMain();
                int recupSaisie = getRecupSaisie(); // recupere la saisie du joueur

                if (recupSaisie != 9) { //si saisie == 9 alors le joueur passe son tour
                    try {
                        if ((mana - main.get(recupSaisie).getManaCost()) >= 0) {

                            activateSelectedSpell(enemy, recupSaisie); // activation du spell

                        } else {
                            System.out.println("");
                            System.out.println("cout en mana trop elevé");
                        }
                    } catch (Exception e) {
                        System.out.println("saisie invalide");
                    }
                }else {
                    mana = 0;
                }

            }
            displayFinDeTour(enemy);
            if (enemy.getPv() > 0){
                enemy.tourDeCombat(this);
                displayFinDeTour(enemy);
            }
        }
    }

//methode d affichage du fin de tour et reinitialisation du mana
    protected void displayFinDeTour(Player enemy) {
        System.out.println("");
        System.out.println("------ fin du tour --------");
        System.out.println("point de vie du joueur : " + pv + " point d'armure : " + armure);
        System.out.println("point de vie de l'enemie : " + enemy.getPv());
        System.out.println("");
        allMainToDefausse();
        mana = manaMax;
    }

    //methode d activation du spell selectionné


    public void activateSelectedSpell(Player enemy, int recupSaisie) {
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
    protected void mainToDefausse(int recupSaisie) {
        defausse.add(main.get(recupSaisie));
        main.remove(recupSaisie);
    }

    //methode de recuperation de la saisie utilisateur (INT)
    protected static int getRecupSaisie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("choisissez votre spell");

        int recupSaisie = scanner.nextInt();
        return recupSaisie;
    }

    //methode qui affiche les cartes dans la main du joueur
    public void afficheMain() {
        main.forEach(s -> System.out.println("- " + s.getDescription()));
        System.out.printf("\n nb carte deck = %d | nb carte defausse = %d \n",deck.size(),defausse.size());
        System.out.printf("armure actuelle : %d  | force actuelle : %d \n",armure, forcef
        );
    }
}