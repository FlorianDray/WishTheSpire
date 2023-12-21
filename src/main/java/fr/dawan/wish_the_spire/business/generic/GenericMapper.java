package fr.dawan.wish_the_spire.business.generic;

public interface GenericMapper<E,D> {

    D toDto(E entity);
    E toEntity(D dto);
}
