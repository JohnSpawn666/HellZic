package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.album.Album;
import com.hellteam.hellzic.bean.AlbumBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlbumMapperTest {

    AlbumMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new AlbumMapper();
    }

    @Test
    void mapToAlbumNeanTest() {

        Album album = new Album();
        album.id(42L);
        album.label("the label");

        AlbumBean result = mapper.mapToAlbumBean(album);

        Assertions.assertThat(result)
                .isNotNull()
                .extracting(AlbumBean::id, AlbumBean::label)
                .containsExactly(42L, "The Label");
    }

    @Test
    void mapToAlbumEntityWithOneParamTest() {

        AlbumBean albumBean = new AlbumBean();
        albumBean.id(42L);
        albumBean.label("THE LABEL");

        Album response = mapper.mapToAlbumEntity(albumBean);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Album::id, Album::label)
                .containsExactly(42L, "the label");
    }

    @Test
    void mapToAlbumEntityWithTwoParamsTest() {

        AlbumBean albumBean = new AlbumBean();
        albumBean.label("The Label");

        Album response = mapper.mapToAlbumEntity(albumBean, "42");

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Album::id, Album::label)
                .containsExactly(42L, "the label");

    }

}