package fr.dawan.wish_the_spire.business.user;


import fr.dawan.wish_the_spire.business.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends GenericMapper<User, UserDto> {
}