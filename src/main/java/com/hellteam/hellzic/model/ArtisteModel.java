package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.artiste.Artiste;
import com.hellteam.hellzic.bdd.artiste.IArtisteRepository;
import com.hellteam.hellzic.bean.ArtisteBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.mapper.ArtisteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ArtisteModel {

    @Autowired
    IArtisteRepository repository;

    ArtisteMapper mapper = new ArtisteMapper();

    // TODO : TU + uppercase nom artiste


    public ArtisteBean createArtiste(ArtisteBean artisteBean) throws Exception {
        return mapper.mapToArtisteBean(saveArtiste(checkValuesAndMapToBean(artisteBean)));

    }

    private Artiste saveArtiste(Artiste artiste) throws DuplicateException {
        try {
            return repository.save(artiste);
        } catch (Exception ex) {
            throw new DuplicateException("L'artiste existe déjà");
        }
    }

    private Artiste checkValuesAndMapToBean(ArtisteBean artisteBean) throws Exception {
        checkValues(artisteBean);
        return mapper.mapToArtiste(artisteBean);
    }

    private void checkValues(ArtisteBean artisteBean) throws Exception {
        if (!StringUtils.hasLength(artisteBean.label())) {
            throw new TechnicalException("Le nom n'est pas renseigné");
        }
    }

}
