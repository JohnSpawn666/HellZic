package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.chansonartist.ChansonArtist;
import com.hellteam.hellzic.bdd.chansonartist.ChansonArtistId;
import com.hellteam.hellzic.bean.ChansonArtistBean;
import org.springframework.stereotype.Component;

@Component
public class ChansonArtistMapper {

    public ChansonArtist mapToChansonArtist(ChansonArtistBean bean) {
        return new ChansonArtist().chansonArtistId(new ChansonArtistId()
                .artistId(bean.artistId())
                .chansonId(bean.chansonId()));
    }
}
