package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.artiste.Artiste;
import com.hellteam.hellzic.bean.ArtisteBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.from;

@SpringBootTest
class ArtisteBeanMapperTest {

    ArtisteMapper artisteMapper = new ArtisteMapper();

    @Test
    void mapToArtisteDtoTest() {
        ArtisteBean artisteBean = new ArtisteBean()
                .id(45L)
                .label("labelArtiste");

        Artiste response = artisteMapper.mapToArtiste(artisteBean);

        Assertions.assertThat(response)
                .returns(45L, from(Artiste::id))
                .returns("labelArtiste", from(Artiste::label));
    }

    @Test
    void mapToArtisteTest() {
        Artiste artiste = new Artiste()
                .id(25L)
                .label("labelArtiste");

        ArtisteBean response = artisteMapper.mapToArtisteBean(artiste);

        Assertions.assertThat(response)
                .returns(25L, from(ArtisteBean::id))
                .returns("labelArtiste", from(ArtisteBean::label));
    }

}