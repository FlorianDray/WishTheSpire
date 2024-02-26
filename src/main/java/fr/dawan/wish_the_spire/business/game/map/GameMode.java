package fr.dawan.wish_the_spire.business.game.map;

import fr.dawan.wish_the_spire.business.game.actors.Player;
import fr.dawan.wish_the_spire.business.game.actors.PlayerEnemy;
import fr.dawan.wish_the_spire.business.game.spell.Effect;
import fr.dawan.wish_the_spire.business.game.spell.Spell;
import fr.dawan.wish_the_spire.business.game.spell.TypeEffect;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Getter
@Setter
public class GameMode {
    private List<TypeEtage> niveau = new ArrayList<TypeEtage>();
    private int etageActuelle;
    private TypeEtage typeEtageActuelle;
    private int difficulty;


    public GameMode() {
        etageActuelle = 0;
        difficulty = 0;
        niveau.add(TypeEtage.SPAWN);
        genereNiveau();
        typeEtageActuelle = TypeEtage.SPAWN;
    }

    public void launchGame(Player player) throws IOException {

        displayMap();

        do {
            niveauSuivant();
            levelActif(player);

        }while (playerIsAlive(player));

    }

    private void genereNiveau() {
        int n;
        Random random = new Random();

        // le premier niveau apres le spawn est forcement un event ou un combat
        if (random.nextBoolean()) {
            niveau.add(TypeEtage.COMBAT);
        } else {
            niveau.add(TypeEtage.EVENEMENT);
        }

        for (int i = 2 ; i<9 ; i++){
            n = random.nextInt(3);


            switch (n){
                case 0:
                    if (niveau.size() > 2 && (niveau.get(i - 1) == TypeEtage.COMBAT && niveau.get(i - 2) == TypeEtage.COMBAT)){
                        niveau.add(TypeEtage.EVENEMENT);
                    }else {
                        niveau.add(TypeEtage.COMBAT);
                    }
                    break;

                case 1:
                    if (niveau.size() > 2 && (niveau.get(i - 1) == TypeEtage.EVENEMENT && niveau.get(i - 2) == TypeEtage.EVENEMENT)){
                        niveau.add(TypeEtage.COMBAT);
                    }else {
                        niveau.add(TypeEtage.EVENEMENT);
                    }
                    break;

                case 2:
                    if (niveau.size() > 2 && (niveau.get(i - 1) == TypeEtage.MARCHAND || niveau.get(i - 2) == TypeEtage.MARCHAND)){
                        niveau.add(TypeEtage.COMBAT);
                    }else {
                        niveau.add(TypeEtage.MARCHAND);
                    }
                    break;
            }

        }
        niveau.add(TypeEtage.BOSS);
    }

    public void displayMap(){
        niveau.forEach(System.out::println);
    }

    public void niveauSuivant(){

        if (etageActuelle == niveau.size() - 1){
            niveau.clear();
            genereNiveau();
            difficulty++;
        }
        etageActuelle++;
    }

    public void levelActif(Player player) throws IOException {
        switch (niveau.get(etageActuelle)){
            case COMBAT -> combatStage(player);
            case EVENEMENT -> eventStage();
            case MARCHAND -> marchandStage();
            case BOSS -> bossStage();
        }
    }

    private void bossStage() {
    }

    private void marchandStage() {
    }

    private void eventStage() throws IOException {
        System.out.println("vous entrez dans un evenement (appuyer sur une touche pour continuer)");
        System.in.read();
    }

    private void combatStage(Player player) throws IOException {
        System.out.println("vous entrez dans la piece et vous tombez nez à nez avec un enemie (appuyer sur une touche pour continuer)");
        System.in.read();
        List<Spell> spellListPlayer = new ArrayList<Spell>();
        List<Spell> spellMainPlayer = new ArrayList<Spell>();
        List<Spell> spellDefaussePlayer = new ArrayList<Spell>();

        List<Effect> effects = new ArrayList<>();
        effects.add(new Effect(TypeEffect.DAMAGE, 3));
        effects.add(new Effect(TypeEffect.HEAL, 2));

        Spell volDeVie = new Spell(2, "vol la vie de l enemie",effects);

        spellListPlayer.add(volDeVie);
        spellListPlayer.add(volDeVie);
        spellListPlayer.add(volDeVie);

        effects = new ArrayList<>();
        effects.add(new Effect(TypeEffect.DAMAGE, 1));

        Spell baseAttack = new Spell(1, "attaque de base",effects);

        spellListPlayer.add(baseAttack);
        spellListPlayer.add(baseAttack);

        PlayerEnemy enemy = new PlayerEnemy(10,0,2,0,1,1,1,spellMainPlayer ,spellListPlayer,spellDefaussePlayer);

        player.tourDeCombat(enemy);
    }

    private boolean playerIsAlive(Player player){
        return player.getPv() > 0;
    }


}
