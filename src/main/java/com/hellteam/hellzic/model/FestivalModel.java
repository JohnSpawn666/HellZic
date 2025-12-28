package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.festival.Festival;
import com.hellteam.hellzic.bdd.festival.IFestivalRepository;
import com.hellteam.hellzic.bean.FestivalBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.mapper.IFestivalMapper;
import com.hellteam.hellzic.mapper.IFestivalMapperImpl;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FestivalModel {

    IFestivalRepository repository;
    IFestivalMapper mapper;

    /**
     * Constructeur
     *
     * @param repository Accès à la BDD
     */
    public FestivalModel(IFestivalRepository repository) {
        this.repository = repository;
        this.mapper = new IFestivalMapperImpl();
    }

    /**
     * Création du festival
     *
     * @param festivalBean Bean contenant les données
     * @return bean contenant les données enregistrées
     * @throws TechnicalException Erreur techniques
     * @throws DuplicateException Erreurs de duplications
     */
    public FestivalBean create(FestivalBean festivalBean) throws TechnicalException, DuplicateException {
        return mapper.mapToFestivalBean(saveFestival(mapper.mapToFestival(checkValues(festivalBean))));
    }

    /**
     * Enregistrement d'un festival
     *
     * @param festival Objet contenant les données à enregistrer
     * @return Objet contenant les données enregistrées
     * @throws DuplicateException Erreurs de duplication
     */
    private Festival saveFestival(Festival festival) throws DuplicateException {
        try {
            return repository.save(festival);
        } catch (Exception _) {
            throw new DuplicateException("Le festival existe déjà");
        }
    }

    /**
     * Vérification des différentes valeurs
     *
     * @param festivalBean Objet contenant les données à vérifier
     * @return Objet avec données OK
     * @throws TechnicalException Erreurs techniques de validation
     */
    private FestivalBean checkValues(FestivalBean festivalBean) throws TechnicalException {
        CheckUtil.checkNullValues(festivalBean.getLabel(), "Le nom du festival");
        return festivalBean;
    }

    /**
     * Mise à jour d'un festival
     *
     * @param festivalBean Objet contenant les données à mettre à jour
     * @param id           ID de l'objet à mettre à jour
     * @return Objet mis à jour
     * @throws NoneException      Aucun festival trouvé
     * @throws DuplicateException Erreurs de duplications
     */
    public FestivalBean update(FestivalBean festivalBean, String id)
            throws NoneException, DuplicateException {
        try {
            return mapper.mapToFestivalBean(repository.save(mapper.mapToFestival(festivalBean, id)));
        } catch (Exception ex) {
            if (ex.getMessage().startsWith("Row was already updated or deleted")) {
                throw new NoneException("Aucun festival n'a été trouvé");
            } else if (((ConstraintViolationException) ex.getCause()).getKind().name().equals("UNIQUE")) {
                throw new DuplicateException("Le festival existe déjà");
            }
            throw new NoneException("ID non existant");
        }

    }

    /**
     * Selection d'un festival
     *
     * @param id ID de l'objet à sélectionner
     * @return Objet correspondant à l'ID
     */
    public FestivalBean select(String id) {
        return mapper.mapToFestivalBean(repository.getReferenceById(Long.parseLong(id)));
    }

    /**
     * Recherche d'un festival par rapport à un texte
     *
     * @param label Texte pour rechercher le festival
     * @return Liste des festivals dont le nom contient le texte d'entrée
     */
    public List<FestivalBean> findByLabel(String label) {
        return repository.findByLabelContaining(label).stream()
                .map(entity -> mapper.mapToFestivalBean(entity))
                .toList();
    }

    /**
     * Suppression d'un festival
     *
     * @param id ID du festival à supprimer
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
