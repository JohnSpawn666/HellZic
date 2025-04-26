package com.hellteam.hellzic.service.chansonartist;

import com.hellteam.hellzic.bean.ChansonArtistBean;
import com.hellteam.hellzic.model.ChansonArtistModel;
import org.springframework.stereotype.Service;

@Service
public class ChansonArtisteServiceImpl implements IChansonArtistService {

    private final ChansonArtistModel model;

    public ChansonArtisteServiceImpl(ChansonArtistModel model) {
        this.model = model;
    }

    @Override
    public void create(ChansonArtistBean bean) {
        model.create(bean);
    }

}
