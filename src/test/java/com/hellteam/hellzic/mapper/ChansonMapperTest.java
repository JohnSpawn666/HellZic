package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.chanson.Chanson;
import com.hellteam.hellzic.bean.ChansonBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChansonMapperTest {

    IChansonMapper chansonMapper;

    @BeforeEach
    void setUp() {
        chansonMapper = new IChansonMapperImpl();
    }

    @Test
    void mapToChansonWithOneParamTest() {

        ChansonBean chansonBean = new ChansonBean();
        chansonBean.setTitre("SCARS");
        chansonBean.setAlbumId(42L);

        Chanson response = chansonMapper.mapToChanson(chansonBean);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Chanson::getLabel, Chanson::getAlbumId)
                .containsExactly("scars", 42L);
    }

    @Test
    void mapToChansonWithTwoParams() {

        ChansonBean chansonBean = new ChansonBean();
        chansonBean.setTitre("SCARS");
        chansonBean.setAlbumId(25L);

        Chanson response = chansonMapper.mapToChanson(chansonBean, "42");

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Chanson::getId, Chanson::getAlbumId, Chanson::getLabel)
                .containsExactly(42L, 25L, "scars");
    }

    @ParameterizedTest
    @ValueSource(strings = {"scars", "SCARS"})
    void mapToChansonBean(String label) {

        Chanson chanson = new Chanson();
        chanson.setId(42L);
        chanson.setLabel(label);
        chanson.setAlbumId(25L);


        ChansonBean response = chansonMapper.mapToChansonBean(chanson);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(ChansonBean::getId, ChansonBean::getAlbumId, ChansonBean::getTitre)
                .containsExactly(42L, 25L, "Scars");

    }

}