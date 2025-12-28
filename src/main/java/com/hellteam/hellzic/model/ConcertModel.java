package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.concert.Concert;
import com.hellteam.hellzic.bdd.concert.IConcertRepository;
import com.hellteam.hellzic.bean.ConcertBean;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.NotFoundValueDatabaseException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.mapper.IConcertMapper;
import com.hellteam.hellzic.mapper.IConcertMapperImpl;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class ConcertModel {

    IConcertRepository repository;

    IConcertMapper mapper;

    /**
     * Constructeur
     *
     * @param repository Accès à la BDD
     */
    public ConcertModel(IConcertRepository repository) {
        this.repository = repository;
        mapper = new IConcertMapperImpl();
    }

    /**
     * Création d'un nouveau concert
     *
     * @param bean Bean contenant les données du concert
     * @return Concert créé
     * @throws NotFoundValueDatabaseException Valeurs non trouvées en BDD
     * @throws TechnicalException             Erreur technique lors de la création
     */
    public ConcertBean create(ConcertBean bean)
            throws NotFoundValueDatabaseException, TechnicalException {
        try {
            return mapper.mapToConcertBean(saveConcert(mapper.mapToConcert(bean)));
        } catch (Exception ex) {

            Throwable rootCause = ((DataIntegrityViolationException) ex).getRootCause();
            if (rootCause != null && (rootCause.getMessage() != null)) {

                String message = rootCause.getMessage();

                if (message.contains("salle_id")) {
                    throw new NotFoundValueDatabaseException("Cette salle n'existe pas");
                } else if (message.contains("artist_id")) {
                    throw new NotFoundValueDatabaseException("Cet artiste n'existe pas");
                } else {
                    throw new TechnicalException("Erreur lors de l'enregistrement du concert");
                }
            }
            throw new TechnicalException("Erreur lors de l'enregistrement du concert");

        }
    }

    /**
     * Enregistrement d'un concert en BDD
     *
     * @param concert Bean contenant les données du concert
     * @return Objet avec données du concert enregistrées
     */
    private Concert saveConcert(Concert concert) {
        return repository.save(concert);
    }

    public ConcertBean update(ConcertBean bean, String id) throws TechnicalException, NoneException {
        try {
            return mapper.mapToConcertBean(repository.save(mapper.mapToConcert(bean, id)));
        } catch (NumberFormatException _) {
            throw new TechnicalException("l'ID doit être un nombre");
        } catch (Exception _) {
            throw new NoneException("L'ID ne doit pas être null");
        }

    }

    /**
     * Sélection d'un concert
     *
     * @param id ID du concert qu'on recherche
     * @return Concert sélectionné
     * @throws NoneException Aucun concert trouvé
     */
    public ConcertBean select(String id) throws NoneException {
        try {
            return mapper.mapToConcertBean(repository.getReferenceById(Long.parseLong(id)));
        } catch (Exception _) {
            throw new NoneException("Aucun concert trouvé avec l'album " + id);
        }
    }

    /**
     * Suppression du concert
     *
     * @param id ID du concert qu'on veut supprimer
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
