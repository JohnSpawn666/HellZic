package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.chanson.Chanson;
import com.hellteam.hellzic.bdd.chanson.IChansonRepository;
import com.hellteam.hellzic.bean.ChansonBean;
import com.hellteam.hellzic.error.*;
import com.hellteam.hellzic.mapper.IChansonMapper;
import com.hellteam.hellzic.mapper.IChansonMapperImpl;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChansonModel {

    IChansonRepository repository;

    IChansonMapper chansonMapper;

    /**
     * Constructeur
     *
     * @param repository CRUD du bean Chanson
     */
    public ChansonModel(IChansonRepository repository) {
        this.repository = repository;
        this.chansonMapper = new IChansonMapperImpl();
    }

    /**
     * Création d'un nouvelle chanson
     *
     * @param chansonBean Bean avec les données de la chanson
     * @return Chanson créée
     * @throws TechnicalException    l'ID n'est pas au bon format
     * @throws NotFoundValueDatabase Album non existant
     * @throws DuplicateException    Valeur déjà existante
     * @throws NullException         Titre non renseigné
     */
    public ChansonBean createChanson(ChansonBean chansonBean) throws TechnicalException, NotFoundValueDatabase, DuplicateException, NullException {
        checkValues(chansonBean);
        return chansonMapper.mapToChansonBean(saveChanson(chansonBean, chansonMapper.mapToChanson(chansonBean)));
    }

    /**
     * Enregristrement d'une nouvelle chanson
     *
     * @param chansonBean Bean avec les données de la chanson
     * @param entity      Valeurs à enregristrer en BDD
     * @return Bean enreigistré en BDD
     * @throws DuplicateException    Valeurs déjà existantes
     * @throws NotFoundValueDatabase Valeurs non existantes
     */
    private Chanson saveChanson(ChansonBean chansonBean, Chanson entity) throws DuplicateException, NotFoundValueDatabase {
        try {
            return repository.save(entity);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getMessage().contains("uni_label_album")) {
                throw new DuplicateException("Une chanson existe déjà avec le titre " + chansonBean.titre + " et l'album " + chansonBean.getAlbumId());
            }
            throw new NotFoundValueDatabase("ID de l'album " + chansonBean.albumId + " non trouvé dans la BDD");
        }
    }

    /**
     * Vérification des différents paramètres
     *
     * @param chansonBean Bean à vérifier
     * @throws TechnicalException l'ID n'est pas au bon format
     * @throws NullException      ID de l'album non renseigné
     */
    private void checkValues(ChansonBean chansonBean) throws TechnicalException, NullException {
        CheckUtil.checkNullValues(chansonBean.getTitre(), "Le titre de la chanson");

        if (chansonBean.albumId == null) {
            throw new NullException("L'ID de l'album doit être renseigné");
        }
    }

    /**
     * Mise à jour d'une chanson
     *
     * @param chansonBean Bean avec les nouvelles données à mettre à jour
     * @param id          ID de la chanson à mettre à jour
     * @return Bean mis à jour
     * @throws TechnicalException l'ID n'est pas au bon format
     * @throws NoneException      ID non existant
     */
    public ChansonBean updateChanson(ChansonBean chansonBean, String id) throws TechnicalException, NoneException {
        try {
            return chansonMapper.mapToChansonBean(repository.save(chansonMapper.mapToChanson(chansonBean, id)));
        } catch (NumberFormatException _) {
            throw new TechnicalException("L'ID doit être un nombre");
        } catch (Exception _) {
            throw new NoneException("L'ID doit déjà exister");
        }

    }

    /**
     * Recherche d'une chanson par son ID
     *
     * @param id ID de la chanson à rechercher
     * @return Chanson trouvée
     * @throws NoneException Aucune chanson trouvée
     */
    public ChansonBean selectChansonById(String id) throws NoneException {
        try {
            return chansonMapper.mapToChansonBean(repository.getReferenceById(Long.parseLong(id)));
        } catch (Exception _) {
            throw new NoneException("Aucune chanson trouvé avec l'ID " + id);
        }

    }

    /**
     * Recherche de chansons par le label
     *
     * @param label Chaine de caractères
     * @return Chanson dont le titre contient la chaine de caractères
     */
    public List<ChansonBean> findByLabel(String label) {
        return repository.findByLabelContaining(label.toLowerCase()).stream()
                .map(dao -> chansonMapper.mapToChansonBean(dao))
                .toList();
    }

    /**
     * Suppression d'une chanson par son ID
     *
     * @param id ID de la chanson à supprimer
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
