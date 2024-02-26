package fr.dawan.wish_the_spire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WishTheSpireApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WishTheSpireApplication.class, args);

		/*List<Spell> spellListPlayer = new ArrayList<Spell>();
		List<Spell> spellMainPlayer = new ArrayList<Spell>();
		List<Spell> spellDefaussePlayer = new ArrayList<Spell>();

		List<Effect> effects = new ArrayList<>();
		effects.add(new Effect(TypeEffect.DAMAGE, 3));
		effects.add(new Effect(TypeEffect.HEAL, 2));

		Spell volDeVie = new Spell(2, "vol la vie de l enemie",effects);

		spellListPlayer.add(volDeVie);
		/*spellListPlayer.add(volDeVie);
		spellListPlayer.add(volDeVie);*/

		/*effects = new ArrayList<>();
		effects.add(new Effect(TypeEffect.DAMAGE, 1));

		Spell baseAttack = new Spell(1, "attaque de base",effects);

		spellListPlayer.add(baseAttack);
		spellListPlayer.add(baseAttack);
		spellListPlayer.add(baseAttack);

		effects = new ArrayList<>();
		effects.add(new Effect(TypeEffect.ARMOR, 5));

		Spell baseProtection = new Spell(1, "gagne 5 d'armure",effects);

		spellListPlayer.add(baseProtection);
		spellListPlayer.add(baseProtection);


		//EntityEnemy enemy = new EntityEnemy(10,0,2,0,1,1,1,spellMainPlayer ,spellListPlayer,spellDefaussePlayer);

		effects = new ArrayList<>();
		effects.add(new Effect(TypeEffect.FORCE, 2));

		Spell gainForce = new Spell(2, "gagne 2 de force pour le reste du combat",effects);

		spellListPlayer.add(gainForce);


		Entity player = new Entity(10,0,2,0,3,3,5,spellMainPlayer ,spellListPlayer,spellDefaussePlayer);

		/*player.tourDeCombat(enemy);

		System.out.println("point de vie du joueur : " + player.getPv());
		System.out.println("point de vie de l'enemie : " + enemy.getPv());*/
		/*GameMode gameMode = new GameMode();
		gameMode.launchGame(player);*/

	}
	//test
}
