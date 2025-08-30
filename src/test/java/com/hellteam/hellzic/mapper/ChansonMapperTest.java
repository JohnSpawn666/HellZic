package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.chanson.Chanson;
import com.hellteam.hellzic.bean.ChansonBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChansonMapperTest {

    ChansonMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ChansonMapper();
    }

    @Test
    void mapToChansonWithOneParamTest() {

        ChansonBean chansonBean = new ChansonBean();
        chansonBean.titre("SCARS");
        chansonBean.albumId(42L);

        Chanson response = mapper.mapToChanson(chansonBean);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Chanson::label, Chanson::albumId)
                .containsExactly("scars", 42L);
    }

    @Test
    void mapToChansonWithTwoParams() {

        ChansonBean chansonBean = new ChansonBean();
        chansonBean.titre("SCARS");
        chansonBean.albumId(25L);

        Chanson response = mapper.mapToChanson(chansonBean, "42");

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Chanson::id, Chanson::albumId, Chanson::label)
                .containsExactly(42L, 25L, "scars");
    }

    @ParameterizedTest
    @ValueSource(strings = {"scars", "SCARS"})
    void mapToChansonBean(String label) {

        Chanson chanson = new Chanson();
        chanson.id(42L);
        chanson.label(label);
        chanson.albumId(25L);


        ChansonBean response = mapper.mapToChansonBean(chanson);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(ChansonBean::id, ChansonBean::albumId, ChansonBean::titre)
                .containsExactly(42L, 25L, "Scars");

    }

}