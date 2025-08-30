package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.artiste.Artiste;
import com.hellteam.hellzic.bean.ArtisteBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArtisteMapperTest {

    ArtisteMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ArtisteMapper();
    }

    @Test
    void mapToArtisteBean() {

        Artiste artiste = new Artiste();
        artiste.id(42L);
        artiste.label("alissa white-gluz");

        ArtisteBean response = mapper.mapToArtisteBean(artiste);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(ArtisteBean::id, ArtisteBean::label)
                .containsExactly(42L, "ALISSA WHITE-GLUZ");
    }

    @Test
    void mapToArtisteTestWithOneParam() {

        ArtisteBean artisteBean = new ArtisteBean();
        artisteBean.id(42L);
        artisteBean.label("alissa white-gluz");

        Artiste response = mapper.mapToArtiste(artisteBean);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Artiste::id, Artiste::label)
                .containsExactly(42L, "alissa white-gluz");
    }

    @Test
    void mapToArtisteWithTwoParamsTest() {

        ArtisteBean artisteBean = new ArtisteBean();
        artisteBean.label("alissa white-gluz");

        Artiste response = mapper.mapToArtiste(artisteBean, "42");

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Artiste::id, Artiste::label)
                .containsExactly(42L, "alissa white-gluz");

    }

}