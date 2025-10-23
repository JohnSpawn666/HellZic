package com.hellteam.hellzic.mapper.album;

import com.hellteam.hellzic.bdd.album.Album;
import com.hellteam.hellzic.bean.AlbumBean;
import com.hellteam.hellzic.model.CapitalizeUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface IAlbumMapper {

    @Named("capitalizeEachWords")
    static String capitalizeEachWords(String label) {
        return CapitalizeUtil.capitalizeEachWord(label.toLowerCase());
    }

    @Mapping(target = "id", source = "album.id")
    @Mapping(target = "label", source = "album.label", qualifiedByName = "capitalizeEachWords")
    AlbumBean mapToAlbumBean(Album album);

    @Mapping(target = "label", expression = "java(album.getLabel().toLowerCase())")
    @Mapping(target = "id", source = "album.id")
    Album mapToAlbumEntity(AlbumBean album);

    @Mapping(target = "label", expression = "java(album.getLabel().toLowerCase())")
    @Mapping(target = "id", expression = "java(Long.parseLong(id))")
    Album mapToAlbumEntity(AlbumBean album, String id);


}
