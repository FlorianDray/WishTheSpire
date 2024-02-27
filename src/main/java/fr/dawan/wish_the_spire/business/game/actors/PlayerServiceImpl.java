package fr.dawan.wish_the_spire.business.game.actors;

import fr.dawan.wish_the_spire.business.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl extends GenericServiceImpl<Player,PlayerRepository,PlayerDto,PlayerMapper> implements PlayerService {
    public PlayerServiceImpl(PlayerRepository repository, PlayerMapper mapper) {
        super(repository, mapper);
    }
}
