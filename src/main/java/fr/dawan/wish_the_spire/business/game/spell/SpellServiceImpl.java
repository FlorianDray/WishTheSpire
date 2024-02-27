package fr.dawan.wish_the_spire.business.game.spell;

import fr.dawan.wish_the_spire.business.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SpellServiceImpl extends GenericServiceImpl<Spell,SpellRepository,SpellDto,SpellMapper> implements SpellService{
    public SpellServiceImpl(SpellRepository repository, SpellMapper mapper) {
        super(repository, mapper);
    }
}
