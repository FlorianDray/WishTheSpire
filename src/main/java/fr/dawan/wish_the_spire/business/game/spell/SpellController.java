package fr.dawan.wish_the_spire.business.game.spell;

import fr.dawan.wish_the_spire.business.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spells")
public class SpellController extends GenericController<SpellDto,SpellService> {
    public SpellController(SpellService service) {
        super(service);
    }
}
