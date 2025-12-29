package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.artistedition.ArtistEdition;
import com.hellteam.hellzic.bdd.artistedition.IArtistEditionRepository;
import com.hellteam.hellzic.bean.ArtistEditionBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.mapper.IArtistEditionMapper;
import com.hellteam.hellzic.mapper.IArtistEditionMapperImpl;
import org.springframework.stereotype.Component;

@Component
public class ArtistEditionModel {

    IArtistEditionRepository repository;
    IArtistEditionMapper mapper;

    /**
     * Constructeur
     *
     * @param repository Accès à la BDD
     */
    public ArtistEditionModel(IArtistEditionRepository repository) {
        this.repository = repository;
        this.mapper = new IArtistEditionMapperImpl();
    }

    /**
     * Création d'un artiste en édition
     *
     * @param artistEditionBean Objet contenant les données à enregistrer
     * @return Objet enregistré
     * @throws DuplicateException Données déjà enregistrées
     */
    public ArtistEditionBean create(ArtistEditionBean artistEditionBean) throws DuplicateException {

        try {
            return mapper.mapToArtistEditionBean(saveArtistEdition(mapper.mapToArtistEdition(artistEditionBean)));
        } catch (Exception _) {
            throw new DuplicateException("Cet artiste existe déjà pour cette édition");
        }
    }

    /**
     * Enregistrement d'une édition d'un artiste
     *
     * @param artistEdition Objet contenant les données a enregistrer
     * @return Objet contenant les données enregistrées
     * @throws DuplicateException Données déjà enregistrées
     */
    private ArtistEdition saveArtistEdition(ArtistEdition artistEdition) throws DuplicateException {
        try {
            return repository.save(artistEdition);
        } catch (Exception _) {
            throw new DuplicateException("Cet artiste a déjà été enregistré pour cette edition");
        }
    }
}
