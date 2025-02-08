package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.artiste.Artiste;
import com.hellteam.hellzic.bean.ArtisteBean;

public class ArtisteMapper {

    public ArtisteBean mapToArtisteBean(Artiste artiste) {
        return new ArtisteBean()
                .id(artiste.id())
                .label(artiste.label());
    }

    public Artiste mapToArtiste(ArtisteBean artisteBean) {
        return new Artiste()
                .id(artisteBean.id())
                .label(artisteBean.label());

    }

}
