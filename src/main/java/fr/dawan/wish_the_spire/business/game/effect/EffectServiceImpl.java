package fr.dawan.wish_the_spire.business.game.effect;

import fr.dawan.wish_the_spire.business.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EffectServiceImpl extends GenericServiceImpl<Effect,EffectRepository,EffectDto,EffectMapper> implements EffectService{
    public EffectServiceImpl(EffectRepository repository, EffectMapper mapper) {
        super(repository, mapper);
    }
}
