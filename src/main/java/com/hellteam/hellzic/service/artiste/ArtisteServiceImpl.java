package com.hellteam.hellzic.service.artiste;

import com.hellteam.hellzic.bean.ArtisteBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.model.ArtisteModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtisteServiceImpl implements IArtisteService {

    ArtisteModel model;

    public ArtisteServiceImpl(ArtisteModel model) {
        this.model = model;
    }

    @Override
    public ArtisteBean createArtiste(ArtisteBean artisteBean) throws TechnicalException, DuplicateException {
        return model.createArtiste(artisteBean);
    }

    @Override
    public ArtisteBean updateArtiste(ArtisteBean artisteBean, String id) throws TechnicalException, NoneException {
        return model.updateArtiste(artisteBean, id);
    }

    @Override
    public ArtisteBean selectArtiste(String id) throws NoneException {
        return model.selectArtiste(id);
    }

    @Override
    public List<ArtisteBean> findByLabel(String label) {
        return model.findByLabel(label);
    }

    @Override
    public void deleteById(Long id) {
        model.deleteById(id);
    }

}
