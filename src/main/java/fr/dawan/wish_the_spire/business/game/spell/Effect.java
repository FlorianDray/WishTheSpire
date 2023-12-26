package fr.dawan.wish_the_spire.business.game.spell;

import fr.dawan.wish_the_spire.business.game.actors.Entity;

public class Effect extends Entity {
    private TypeEffect type;
    private int value;
    void healing(int heal, Entity target) {
        target.setPv(target.getPv() + heal);
    }

    void addMana(int mana, Entity target) {
        target.setMana(target.getMana() + mana);
    }

    void gainForce(int force, Entity target) {
        target.setForce(target.getForce() + force);
    }

    void activateEffect(Entity target) {
        switch (type) {
            case HEAL -> healing(value,target);
            case FORCE -> gainForce(value,target);
        }
    }
}
