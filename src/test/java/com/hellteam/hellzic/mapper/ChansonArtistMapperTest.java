package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.chansonartist.ChansonArtist;
import com.hellteam.hellzic.bdd.chansonartist.ChansonArtistId;
import com.hellteam.hellzic.bean.ChansonArtistBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChansonArtistMapperTest {

    ChansonArtistMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ChansonArtistMapper();
    }

    @Test
    void mapToChansonArtistTest() {

        ChansonArtistBean chansonArtistBean = new ChansonArtistBean();
        chansonArtistBean.artistId(4L);
        chansonArtistBean.chansonId(6L);

        ChansonArtist response = mapper.mapToChansonArtist(chansonArtistBean);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(ChansonArtist::chansonArtistId)
                .isNotNull()
                .extracting(ChansonArtistId::artistId, ChansonArtistId::chansonId)
                .containsExactly(4L, 6L);

    }

}