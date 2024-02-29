package fr.dawan.wish_the_spire.business.game.effect;

import fr.dawan.wish_the_spire.business.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/effects")
public class EffectController extends GenericController<EffectDto,EffectService> {
    public EffectController(EffectService service) {
        super(service);
    }
}
