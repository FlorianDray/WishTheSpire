package fr.dawan.wish_the_spire.business.game.effect;

import fr.dawan.wish_the_spire.business.game.actors.Player;
import fr.dawan.wish_the_spire.business.generic.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
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

        if (caster.getStatAffaibli() > 0){
            dmg = dmg - (int) (dmg * 0.4);
        }

        if (target.getStatBlessure() > 0){
            dmg = (int) (dmg * 1.5);
        }

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


    public void activateEffect(Player caster, Player target) {
        switch (type) {
            case HEAL -> healing(value, caster);
            case FORCE -> gainForce(value, caster);
            case MANA -> addMana(value, caster);
            case DEXTERITE -> gainDexterite(value, caster);
            case DAMAGE -> attack(value, caster, target);
            case ARMOR -> addArmor(value, caster);
            case STUN -> stun(value,target);
            case AFFAIBLI -> affaibli(value,target);
            case POISON -> poison(value,target);
            case BLESSURE -> blessure(value,target);
        }
    }

    private void blessure(int value, Player target) {
        target.setStatBlessure(target.getStatBlessure() + value);
    }

    private void poison(int value, Player target) {
        target.setStatPoison(target.getStatPoison() + value);
    }

    private void affaibli(int value, Player target) {
        target.setStatAffaibli(target.getStatAffaibli() + value);
    }
}
