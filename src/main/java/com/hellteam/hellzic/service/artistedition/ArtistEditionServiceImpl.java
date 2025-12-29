package com.hellteam.hellzic.service.artistedition;

import com.hellteam.hellzic.bean.ArtistEditionBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.model.ArtistEditionModel;
import org.springframework.stereotype.Service;

@Service
public class ArtistEditionServiceImpl implements IArtistEditionService {

    ArtistEditionModel model;

    public ArtistEditionServiceImpl(ArtistEditionModel model) {
        this.model = model;
    }

    @Override
    public ArtistEditionBean create(ArtistEditionBean artistEditionBean) throws DuplicateException {
        return model.create(artistEditionBean);
    }

}
