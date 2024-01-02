package fr.dawan.wish_the_spire.business.game.spell;

import fr.dawan.wish_the_spire.business.game.actors.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Effect extends Entity {
    private TypeEffect type;

    private int value;
    void healing(int heal, Entity caster) {
        caster.setPv(caster.getPv() + heal);
    }

    void addMana(int mana, Entity caster) {
        caster.setMana(caster.getMana() + mana);
    }

    void gainForce(int force, Entity caster) {
        caster.setForce(caster.getForce() + force);
    }

    void gainDexterite(int dext, Entity caster) { caster.setDexterite(caster.getDexterite() + dext);}

    void attack(int dmg, Entity caster, Entity target) {
        dmg =  (caster.getForce() + dmg);

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

    void addArmor(int armor, Entity caster) { caster.setArmure(caster.getArmure() + armor + caster.getDexterite() );}


    void activateEffect(Entity caster, Entity target) {
        switch (type) {
            case HEAL -> healing(value, caster);
            case FORCE -> gainForce(value, caster);
            case MANA -> addMana(value, caster);
            case DEXTERITE -> gainDexterite(value, caster);
            case DAMAGE -> attack(value, caster, target);
            case ARMOR -> addArmor(value, caster);
        }
    }
}
