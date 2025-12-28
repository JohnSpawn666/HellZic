package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.festival.Festival;
import com.hellteam.hellzic.bean.FestivalBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IFestivalMapper {

    @Mapping(target = "id", source = "bean.id")
    @Mapping(target = "label", source = "bean.label")
    Festival mapToFestival(FestivalBean bean);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "label", source = "entity.label")
    FestivalBean mapToFestivalBean(Festival entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "label", source = "bean.label")
    Festival mapToFestival(FestivalBean bean, String id);
}
