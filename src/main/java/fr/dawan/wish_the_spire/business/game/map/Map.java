package fr.dawan.wish_the_spire.business.game.map;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Map {
    private List<TypeEtage> niveau = new ArrayList<TypeEtage>();
    private int etageActuelle;
    private TypeEtage typeEtageActuelle;

    public Map() {
        etageActuelle = 0;
        niveau.add(TypeEtage.SPAWN);
        genereNiveau();
        typeEtageActuelle = TypeEtage.SPAWN;
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
}
