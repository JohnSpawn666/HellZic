package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.artiste.Artiste;
import com.hellteam.hellzic.bean.ArtisteBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArtisteMapperTest {

    IArtisteMapper artisteMapper;

    @BeforeEach
    void setUp() {
        artisteMapper = new IArtisteMapperImpl();
    }

    @Test
    void mapToArtisteBean() {

        Artiste artiste = new Artiste();
        artiste.setId(42L);
        artiste.setLabel("alissa white-gluz");

        ArtisteBean response = artisteMapper.mapToArtisteBean(artiste);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(ArtisteBean::getId, ArtisteBean::getLabel)
                .containsExactly(42L, "ALISSA WHITE-GLUZ");
    }

    @Test
    void mapToArtisteTestWithOneParam() {

        ArtisteBean artisteBean = new ArtisteBean();
        artisteBean.setId(42L);
        artisteBean.setLabel("alissa white-gluz");

        Artiste response = artisteMapper.mapToArtiste(artisteBean);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Artiste::getId, Artiste::getLabel)
                .containsExactly(42L, "alissa white-gluz");
    }

    @Test
    void mapToArtisteWithTwoParamsTest() {

        ArtisteBean artisteBean = new ArtisteBean();
        artisteBean.setLabel("alissa white-gluz");

        Artiste response = artisteMapper.mapToArtiste(artisteBean, "42");

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(Artiste::getId, Artiste::getLabel)
                .containsExactly(42L, "alissa white-gluz");

    }

}