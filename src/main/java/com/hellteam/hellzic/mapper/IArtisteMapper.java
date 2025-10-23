package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.artiste.Artiste;
import com.hellteam.hellzic.bean.ArtisteBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IArtisteMapper {

    @Mapping(target = "label", expression = "java(artiste.getLabel().toUpperCase())")
    @Mapping(target = "id", source = "artiste.id")
    ArtisteBean mapToArtisteBean(Artiste artiste);

    @Mapping(target = "id", source = "artisteBean.id")
    @Mapping(target = "label", source = "artisteBean.label")
    Artiste mapToArtiste(ArtisteBean artisteBean);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "label", source = "artisteBean.label")
    Artiste mapToArtiste(ArtisteBean artisteBean, String id);

}
