package fr.dawan.wish_the_spire.business.game.effect;

import fr.dawan.wish_the_spire.business.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EffectMapper extends GenericMapper<Effect,EffectDto> {
}
