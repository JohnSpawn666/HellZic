package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.concert.Concert;
import com.hellteam.hellzic.bean.ConcertBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IConcertMapper {

    @Mapping(target = "id", source = "bean.id")
    @Mapping(target = "salleId", source = "bean.salleId")
    @Mapping(target = "artistId", source = "bean.artistId")
    @Mapping(target = "dateConcert", source = "bean.dateConcert")
    Concert mapToConcert(ConcertBean bean);

    @Mapping(target = "id", source = "concert.id")
    @Mapping(target = "salleId", source = "concert.salleId")
    @Mapping(target = "artistId", source = "concert.artistId")
    @Mapping(target = "dateConcert", source = "concert.dateConcert")
    ConcertBean mapToConcertBean(Concert concert);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "salleId", source = "bean.salleId")
    @Mapping(target = "artistId", source = "bean.artistId")
    @Mapping(target = "dateConcert", source = "bean.dateConcert")
    Concert mapToConcert(ConcertBean bean, String id);
}
