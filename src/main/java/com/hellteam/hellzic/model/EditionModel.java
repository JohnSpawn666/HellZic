package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.edition.Edition;
import com.hellteam.hellzic.bdd.edition.IEditionRepository;
import com.hellteam.hellzic.bean.EditionBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.mapper.IEditionMapper;
import com.hellteam.hellzic.mapper.IEditionMapperImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditionModel {

    IEditionRepository repository;
    IEditionMapper mapper;

    /**
     * Constructeur
     *
     * @param repository Accès à la BDD
     */
    public EditionModel(IEditionRepository repository) {
        this.repository = repository;
        this.mapper = new IEditionMapperImpl();
    }

    /**
     * Création d'une nouvelle édition
     *
     * @param editionBean Objet contenant les données de l'édition à créer
     * @return Objet contenant les données de l'édition créée
     * @throws TechnicalException Erreur technique lors de l'enregistrement
     * @throws DuplicateException Session à enregistrer déjà existante
     */
    public EditionBean create(EditionBean editionBean) throws TechnicalException, DuplicateException {
        return mapper.mapToEditionBean(saveEdition(mapper.mapToEdition(checkValues(editionBean))));
    }

    /**
     * Enregristrement d'une édition
     *
     * @param edition Edition à enregistrer
     * @return Edition enregistrée
     * @throws DuplicateException Edition déjà existante
     */
    private Edition saveEdition(Edition edition) throws DuplicateException {
        try {
            return repository.save(edition);
        } catch (Exception _) {
            throw new DuplicateException("Cette édition existe déjà");
        }
    }

    /**
     * Vérification des différentes valeurs
     *
     * @param editionBean Objet avec les valeurs à vérifier
     * @return Objet avec données OK
     * @throws TechnicalException Erreur de données sur l'objet
     */
    private EditionBean checkValues(EditionBean editionBean) throws TechnicalException {
        if (editionBean.getDateDebut().isAfter(editionBean.getDateFin())) {
            throw new TechnicalException("Les dates de l'édition sont mal renseignées");
        }
        return editionBean;
    }

    /**
     * Mise à jour d'une édition
     *
     * @param editionBean Objet contenant les données à mettr à jour
     * @param id          ID de l'édition à mettre à jour
     * @return Edition mise à jour
     * @throws TechnicalException Erreur technique lors de la mise à jour
     */
    public EditionBean update(EditionBean editionBean, String id) throws TechnicalException {
        if (editionBean.getDateDebut().isAfter(editionBean.getDateFin())) {
            throw new TechnicalException("Les dates de l'édition sont mal renseignées");
        }
        return mapper.mapToEditionBean(repository.save(mapper.mapToEdition(editionBean, id)));
    }

    /**
     * Sélection d'une édition
     *
     * @param id ID de l'édition à sélectionner
     * @return Edition correpondant à l'ID
     */
    public EditionBean select(String id) {
        return mapper.mapToEditionBean(repository.getReferenceById(Long.parseLong(id)));
    }

    /**
     * Recherche d'une édition par endroit
     *
     * @param endroit Morceau de libellé de l'endroit à rechercher
     * @return Liste des endroits trouvés
     */
    public List<EditionBean> findByEndroit(String endroit) {
        return repository.findByEndroitContaining(endroit).stream()
                .map(entity -> mapper.mapToEditionBean(entity))
                .toList();
    }

    /**
     * Suppression d'une édition
     *
     * @param id ID de l'édition à supprimer
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
