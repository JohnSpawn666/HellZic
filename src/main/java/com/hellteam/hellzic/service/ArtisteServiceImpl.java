package com.hellteam.hellzic.service;

import com.hellteam.hellzic.bean.ArtisteBean;
import com.hellteam.hellzic.model.ArtisteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtisteServiceImpl implements IArtisteService {

    @Autowired
    ArtisteModel model;

    @Override
    public ArtisteBean createArtiste(ArtisteBean artisteBean) throws Exception {
        return model.createArtiste(artisteBean);
    }
}
