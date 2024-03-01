package fr.dawan.wish_the_spire.business.game.actors;

import fr.dawan.wish_the_spire.business.game.spell.Spell;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    private String name, picture_path;
    private int pv; // point de vie du joueur
    private int forcef; // point de force s ajoutant au degat
    private int dexterite; // point de dexterite s ajoutant a l armure
    private int armure; // point d armure
    private int mana; // mana du joueur
    private int manaMax; // mana maximum du joueur
    private int nbPiocheCarte; // nb de carte que le joueur pioche par tour

    private List<Spell> deck; // liste des spells possédé du joueur


}
