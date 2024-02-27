package fr.dawan.wish_the_spire.business.game.actors;

import fr.dawan.wish_the_spire.business.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("players")
public class PlayerController extends GenericController<PlayerDto, PlayerService> {
    public PlayerController(PlayerService service) {
        super(service);
    }
}
