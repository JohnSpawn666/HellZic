package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.ChansonArtistBean;
import com.hellteam.hellzic.service.chansonartist.ChansonArtisteServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chansonArtist")
public class ChansonArtistController {

    ChansonArtisteServiceImpl service;

    public ChansonArtistController(ChansonArtisteServiceImpl service) {
        this.service = service;
    }

    public ChansonArtistBean create(ChansonArtistBean chansonArtistBean) {
        service.create(chansonArtistBean);
        return chansonArtistBean;
    }


}
