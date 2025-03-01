package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.album.Album;
import com.hellteam.hellzic.bean.AlbumBean;
import org.springframework.util.StringUtils;

public class AlbumMapper {

    public AlbumBean mapToAlbumBean(Album album) {
        return new AlbumBean()
                .id(album.id())
                .label(StringUtils.capitalize(album.label().toLowerCase()));
    }

    public Album mapToAlbum(AlbumBean bean) {
        return new Album()
                .id(bean.id())
                .label(StringUtils.capitalize(bean.label().toLowerCase()));
    }

    public Album mapToAlbum(AlbumBean bean, String id) {
        return mapToAlbum(bean)
                .id(Long.parseLong(id));
    }

}
