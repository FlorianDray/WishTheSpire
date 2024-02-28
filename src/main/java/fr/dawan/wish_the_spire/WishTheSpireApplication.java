package fr.dawan.wish_the_spire;

import fr.dawan.wish_the_spire.business.game.actors.Player;
import fr.dawan.wish_the_spire.business.game.actors.PlayerRepository;
import fr.dawan.wish_the_spire.business.game.effect.Effect;
import fr.dawan.wish_the_spire.business.game.effect.EffectRepository;
import fr.dawan.wish_the_spire.business.game.effect.TypeEffect;
import fr.dawan.wish_the_spire.business.game.map.GameMode;
import fr.dawan.wish_the_spire.business.game.spell.Spell;
import fr.dawan.wish_the_spire.business.game.spell.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WishTheSpireApplication implements CommandLineRunner {
	@Autowired
	PlayerRepository entityRepo;
	@Autowired
	SpellRepository spellRepo;

	@Autowired
	EffectRepository effectRepository;

	public static List<Player> listEnemy ;
	public static List<Spell> listSpell ;

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx =SpringApplication.run(WishTheSpireApplication.class, args);
		List<Spell> spellMainPlayer = new ArrayList<Spell>();
		List<Spell> spellPlayer = new ArrayList<Spell>();
		List<Spell> spellDefaussePlayer = new ArrayList<Spell>();



		spellPlayer.add(listSpell.get(0));
		spellPlayer.add(listSpell.get(0));
		spellPlayer.add(listSpell.get(0));
		spellPlayer.add(listSpell.get(0));
		spellPlayer.add(listSpell.get(0));
		spellPlayer.add(listSpell.get(0));



		Player player = new Player(10,0,2,0,3,3,5,spellMainPlayer ,spellPlayer,spellDefaussePlayer,false);


		GameMode game = new GameMode(listEnemy);
		game.launchGame(player);
		ctx.close();
		//System.out.println(listEnemy.get(0).getDeck());

	}

	@Override
	public void run(String... args) throws Exception {
		listEnemy = entityRepo.findAll();
		listSpell = spellRepo.findAll();




	}
}
