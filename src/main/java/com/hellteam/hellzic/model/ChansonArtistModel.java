package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.chansonartist.IChansonArtistRepository;
import com.hellteam.hellzic.bean.ChansonArtistBean;
import com.hellteam.hellzic.mapper.IChansonArtistMapper;
import com.hellteam.hellzic.mapper.IChansonArtistMapperImpl;
import org.springframework.stereotype.Component;

@Component
public class ChansonArtistModel {

    IChansonArtistRepository repository;
    IChansonArtistMapper chansonArtistMapper;

    /**
     * Constructeur
     *
     * @param repository CRUD de l'objet
     */
    public ChansonArtistModel(IChansonArtistRepository repository) {
        this.repository = repository;
        chansonArtistMapper = new IChansonArtistMapperImpl();
    }

    /**
     * Création d'un nouveau lien
     *
     * @param bean Bean représentant le lien
     */
    public void create(ChansonArtistBean bean) {
        repository.save(chansonArtistMapper.mapToChansonArtist(bean));
    }
}
