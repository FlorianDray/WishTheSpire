package fr.dawan.wish_the_spire;

import fr.dawan.wish_the_spire.business.game.actors.Entity;
import fr.dawan.wish_the_spire.business.game.spell.Effect;
import fr.dawan.wish_the_spire.business.game.spell.Spell;
import fr.dawan.wish_the_spire.business.game.spell.TypeEffect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WishTheSpireApplication {

	public static void main(String[] args) {
		//SpringApplication.run(WishTheSpireApplication.class, args);

		List<Spell> spellListPlayer = new ArrayList<Spell>();

		List<Effect> effects = new ArrayList<>();
		effects.add(new Effect(TypeEffect.DAMAGE, 3));
		effects.add(new Effect(TypeEffect.HEAL, 2));

		Spell volDeVie = new Spell(2, "vol la vie de l enemie",effects);

		spellListPlayer.add(volDeVie);

		effects = new ArrayList<>();
		effects.add(new Effect(TypeEffect.DAMAGE, 1));

		Spell baseAttack = new Spell(1, "attaque de base",effects);

		spellListPlayer.add(baseAttack);

		effects = new ArrayList<>();
		effects.add(new Effect(TypeEffect.FORCE, 2));

		Spell gainForce = new Spell(2, "gagne 2 de force pour le reste du combat",effects);

		spellListPlayer.add(gainForce);


		Entity player = new Entity(10,0,2,2,3,spellListPlayer);
		Entity enemy = new Entity(10,1,2,2,3,spellListPlayer);

		player.tourDeCombat(enemy);

		System.out.println("point de vie du joueur : " + player.getPv());
		System.out.println("point de vie de l'enemie : " + enemy.getPv());
	}
	//test
}
