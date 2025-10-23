package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.album.Album;
import com.hellteam.hellzic.bean.AlbumBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IAlbumMapper extends IMapper {

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
