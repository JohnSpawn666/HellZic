package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.chanson.Chanson;
import com.hellteam.hellzic.bean.ChansonBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IChansonMapper extends IMapper {

    @Mapping(target = "albumId", source = "bean.albumId")
    @Mapping(target = "label", expression = "java(bean.getTitre().toLowerCase())")
    Chanson mapToChanson(ChansonBean bean);

    @Mapping(target = "albumId", source = "bean.albumId")
    @Mapping(target = "label", expression = "java(bean.getTitre().toLowerCase())")
    @Mapping(target = "id", source = "id")
    Chanson mapToChanson(ChansonBean bean, String id);

    @Mapping(target = "albumId", source = "chanson.albumId")
    @Mapping(target = "titre", source = "chanson.label", qualifiedByName = "capitalizeEachWords")
    @Mapping(target = "id", source = "chanson.id")
    ChansonBean mapToChansonBean(Chanson chanson);

}
