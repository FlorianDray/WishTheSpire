package fr.dawan.wish_the_spire.business.game.spell;

import fr.dawan.wish_the_spire.business.game.actors.Player;
import fr.dawan.wish_the_spire.business.generic.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@jakarta.persistence.Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Effect extends BaseEntity {
    private TypeEffect type;

    private int value;
    void healing(int heal, Player caster) {
        caster.setPv(caster.getPv() + heal);
    }

    void addMana(int mana, Player caster) {
        caster.setMana(caster.getMana() + mana);
    }

    void gainForce(int force, Player caster) {
        caster.setForcef(caster.getForcef() + force);
    }

    void gainDexterite(int dext, Player caster) { caster.setDexterite(caster.getDexterite() + dext);}

    void attack(int dmg, Player caster, Player target) {
        dmg =  (caster.getForcef() + dmg);

        if (target.getArmure() > 0) {
           if (dmg > target.getArmure()) {
               target.setPv(target.getPv() - (dmg - target.getArmure()));
               target.setArmure(0);
           } else {
               target.setArmure(target.getArmure() -  (dmg));
           }
        } else {
            target.setPv(target.getPv() - (dmg));
        }
    }

    void addArmor(int armor, Player caster) { caster.setArmure(caster.getArmure() + armor + caster.getDexterite() );}

    void stun(int nbTurn, Player target){};


    void activateEffect(Player caster, Player target) {
        switch (type) {
            case HEAL -> healing(value, caster);
            case FORCE -> gainForce(value, caster);
            case MANA -> addMana(value, caster);
            case DEXTERITE -> gainDexterite(value, caster);
            case DAMAGE -> attack(value, caster, target);
            case ARMOR -> addArmor(value, caster);
            case STUN -> stun(value,target);
        }
    }
}
