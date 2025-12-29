package com.hellteam.hellzic.service.artistedition;

import com.hellteam.hellzic.bean.ArtistEditionBean;
import com.hellteam.hellzic.error.DuplicateException;
import org.springframework.stereotype.Service;

@Service
public interface IArtistEditionService {

    ArtistEditionBean create(ArtistEditionBean artistEditionBean) throws DuplicateException;

}
