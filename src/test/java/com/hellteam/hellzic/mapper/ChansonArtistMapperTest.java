package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.chansonartist.ChansonArtist;
import com.hellteam.hellzic.bdd.chansonartist.ChansonArtistId;
import com.hellteam.hellzic.bean.ChansonArtistBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChansonArtistMapperTest {

    IChansonArtistMapper chansonArtistMapper;

    @BeforeEach
    void setUp() {
        chansonArtistMapper = new IChansonArtistMapperImpl();
    }

    @Test
    void mapToChansonArtistTest() {

        ChansonArtistBean chansonArtistBean = new ChansonArtistBean();
        chansonArtistBean.setArtistId(4L);
        chansonArtistBean.setChansonId(6L);

        ChansonArtist response = chansonArtistMapper.mapToChansonArtist(chansonArtistBean);

        Assertions.assertThat(response)
                .isNotNull()
                .extracting(ChansonArtist::getChansonArtistId)
                .isNotNull()
                .extracting(ChansonArtistId::getArtistId, ChansonArtistId::getChansonId)
                .containsExactly(4L, 6L);

    }

}