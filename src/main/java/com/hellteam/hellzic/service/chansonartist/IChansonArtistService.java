package com.hellteam.hellzic.service.chansonartist;

import com.hellteam.hellzic.bean.ChansonArtistBean;
import org.springframework.stereotype.Service;

@Service
public interface IChansonArtistService {

    void create(ChansonArtistBean bean);

}
