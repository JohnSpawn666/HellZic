package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.album.Album;
import com.hellteam.hellzic.bean.AlbumBean;
import com.hellteam.hellzic.model.CapitalizeUtil;
import org.springframework.stereotype.Component;

@Component
public class AlbumMapper {

    public AlbumBean mapToAlbumBean(Album album) {
        return new AlbumBean()
                .id(album.id())
                .label(CapitalizeUtil.capitalizeEachWord(album.label().toLowerCase()));
    }

    public Album mapToAlbumEntity(AlbumBean bean) {
        return new Album()
                .id(bean.id())
                .label(bean.label().toLowerCase());
    }

    public Album mapToAlbumEntity(AlbumBean bean, String id) {
        return mapToAlbumEntity(bean)
                .id(Long.parseLong(id));
    }

}
