package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.album.Album;
import com.hellteam.hellzic.bean.AlbumBean;
import com.hellteam.hellzic.mapper.album.IAlbumMapper;
import com.hellteam.hellzic.mapper.album.IAlbumMapperImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
class AlbumMapperTest {

    IAlbumMapper mapper = new IAlbumMapperImpl();

    @Test
    void mapToAlbumBeanTest() {

        Album album = new Album();
        album.setId(42L);
        album.setLabel("the label");

        AlbumBean result = mapper.mapToAlbumBean(album);

        Assertions.assertThat(result)
                .isNotNull()
                .extracting(AlbumBean::getId, AlbumBean::getLabel)
                .containsExactly(42L, "The Label");
    }

    @Test
    void mapToAlbumEntityWithOneParamTest() {

        AlbumBean albumBean = new AlbumBean();
        albumBean.setId(42L);
        albumBean.setLabel("THE LABEL");

        Album response = mapper.mapToAlbumEntity(albumBean);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Album::getId, Album::getLabel)
                .containsExactly(42L, "the label");
    }

    @Test
    void mapToAlbumEntityWithTwoParamsTest() {

        AlbumBean albumBean = new AlbumBean();
        albumBean.setLabel("The Label");

        Album response = mapper.mapToAlbumEntity(albumBean, "42");

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Album::getId, Album::getLabel)
                .containsExactly(42L, "the label");

    }

}