package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.salle.ISalleRepository;
import com.hellteam.hellzic.bdd.salle.Salle;
import com.hellteam.hellzic.bean.SalleBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.mapper.ISalleMapper;
import com.hellteam.hellzic.mapper.ISalleMapperImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SalleModel {

    ISalleRepository repository;

    ISalleMapper mapper;

    /**
     * Constructeur
     *
     * @param repository Classe d'accès à la BDD
     */
    public SalleModel(ISalleRepository repository) {
        this.repository = repository;
        this.mapper = new ISalleMapperImpl();
    }

    /**
     * Création d'une salle
     *
     * @param salleBean Bean contenant les données de la salle
     * @return bean représentant la salle créée
     * @throws TechnicalException Erreur de création de la salle
     * @throws DuplicateException Salle déjà existante
     */
    public SalleBean createSalle(SalleBean salleBean) throws TechnicalException, DuplicateException {

        CheckUtil.checkNullValues(salleBean.getLabel(), "Le nom de la salleBean");
        CheckUtil.checkNullValues(salleBean.getDepartmentNumber(), "Le numéro de département");

        return mapper.mapToSalleBean(saveSalle(salleBean, mapper.mapToSalle(salleBean)));
    }

    /**
     * Enregistrement d'une nouvelle salle
     *
     * @param salleBean Bean représentant les données de la salle
     * @param entity    Données de la BDD représentant les données de la salle
     * @return Données de la salle créée
     * @throws DuplicateException Salle déjà existante
     * @throws TechnicalException Erreur lors de la création de la salle
     */
    private Salle saveSalle(SalleBean salleBean, Salle entity)
            throws DuplicateException, TechnicalException {
        try {
            return repository.save(entity);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getMessage().contains("UC_salle")) {
                throw new DuplicateException("Une salle existe déjà " +
                        "dans le departement " + salleBean.getDepartmentNumber()
                        + " et du nom " + salleBean.getLabel());
            } else {
                log.error(ex.getMessage());
                throw new TechnicalException("Erreur lors de la création de la salle");
            }
        }
    }

    /**
     * Mise à jour de la salle
     *
     * @param salleBean Bean représentant les nouvelle données de la salle
     * @param id        ID représentant la salle
     * @return Salle mise à jour
     * @throws DuplicateException Salle déjà existante
     * @throws TechnicalException Erreur lors de la création de la salle
     */
    public SalleBean updateSalle(SalleBean salleBean, String id) throws TechnicalException, DuplicateException {

        CheckUtil.checkNullValues(salleBean.getLabel(), "Le nom de la salleBean");
        CheckUtil.checkNullValues(salleBean.getDepartmentNumber(), "Le numéro de département");

        try {
            return mapper.mapToSalleBean(repository.save(mapper.mapToSalle(salleBean, id)));

        } catch (NumberFormatException _) {
            throw new TechnicalException("L'ID doit être un nombre");
        } catch (Exception _) {
            throw new DuplicateException("L'ID doit déjà exister");
        }

    }

    /**
     * 3
     * Sélection d'une chanson par son ID
     *
     * @param id ID de la salle à recjecher
     * @return Salle correspondant à l'ID
     * @throws NoneException Aucune salle trouvée
     */
    public SalleBean selectSalle(String id) throws NoneException {
        try {
            return mapper.mapToSalleBean(repository.getReferenceById(Long.parseLong(id)));
        } catch (Exception _) {
            throw new NoneException("Aucune salle trouvée avec l'ID " + id);
        }
    }

    /**
     * Recherche de salles via leur label
     *
     * @param label Label dont le nom de la salle le contient
     * @return Liste des salles correspondant au label
     */
    public List<SalleBean> findByLabel(String label) {
        return repository.findByLabelContaining(label.toLowerCase()).stream()
                .map(entity -> mapper.mapToSalleBean(entity))
                .toList();
    }

    /**
     * Suppression d'une salle
     *
     * @param id ID de la salle à supprimer
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
