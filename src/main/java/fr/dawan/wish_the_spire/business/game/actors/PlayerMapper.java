package fr.dawan.wish_the_spire.business.game.actors;

import fr.dawan.wish_the_spire.business.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper extends GenericMapper<Player, PlayerDto> {
}
