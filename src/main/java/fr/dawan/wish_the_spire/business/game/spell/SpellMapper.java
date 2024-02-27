package fr.dawan.wish_the_spire.business.game.spell;

import fr.dawan.wish_the_spire.business.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SpellMapper extends GenericMapper<Spell,SpellDto> {
}
