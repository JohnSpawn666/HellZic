package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.chansonartist.IChansonArtistRepository;
import com.hellteam.hellzic.bean.ChansonArtistBean;
import com.hellteam.hellzic.mapper.ChansonArtistMapper;
import org.springframework.stereotype.Component;

@Component
public class ChansonArtistModel {

    IChansonArtistRepository repository;

    ChansonArtistMapper mapper;

    public ChansonArtistModel(IChansonArtistRepository repository,
                              ChansonArtistMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void create(ChansonArtistBean bean) {
        repository.save(mapper.mapToChansonArtist(bean));
    }
}
