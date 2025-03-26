package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.chanson.Chanson;
import com.hellteam.hellzic.bdd.chanson.IChansonRepository;
import com.hellteam.hellzic.bean.ChansonBean;
import com.hellteam.hellzic.error.*;
import com.hellteam.hellzic.mapper.ChansonMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChansonModel {

    IChansonRepository repository;

    ChansonMapper mapper;

    public ChansonModel(IChansonRepository repository,
                        ChansonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ChansonBean createChanson(ChansonBean chansonBean) throws TechnicalException, NotFoundValueDatabase, DuplicateException, NullException {
        checkValues(chansonBean);
        return mapper.mapToChansonBean(saveChanson(chansonBean, mapper.mapToChanson(chansonBean)));
    }

    private Chanson saveChanson(ChansonBean chansonBean, Chanson entity) throws DuplicateException, NotFoundValueDatabase {
        try {
            return repository.save(entity);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getMessage().contains("uni_label_album")) {
                throw new DuplicateException("Une chanson existe déjà avec le titre " + chansonBean.titre + " et l'album " + chansonBean.albumId());
            }
            throw new NotFoundValueDatabase("ID de l'album " + chansonBean.albumId + " non trouvé dans la BDD");
        }
    }

    private void checkValues(ChansonBean chansonBean) throws TechnicalException, NullException {
        CheckUtil.checkNullValues(chansonBean.titre(), "Le titre de la chanson");

        if (chansonBean.albumId == null) {
            throw new NullException("L'ID de l'album doit être renseigné");
        }
    }

    public ChansonBean updateChanson(ChansonBean chansonBean, String id) throws TechnicalException, NoneException {
        try {
            return mapper.mapToChansonBean(repository.save(mapper.mapToChanson(chansonBean, id)));
        } catch (NumberFormatException ex) {
            throw new TechnicalException("L'ID doit être un nombre");
        } catch (Exception ex) {
            throw new NoneException("L'ID doit déjà exister");
        }

    }

    public ChansonBean selectChanson(String id) throws NoneException {
        try {
            return mapper.mapToChansonBean(repository.getReferenceById(Long.parseLong(id)));
        } catch (Exception ex) {
            throw new NoneException("Aucune chanson trouvé avec l'ID " + id);
        }

    }

    public List<ChansonBean> findByLabel(String label) {
        return repository.findByLabelContaining(label.toLowerCase()).stream()
                .map(dao -> mapper.mapToChansonBean(dao))
                .toList();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
