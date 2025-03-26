package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.artiste.Artiste;
import com.hellteam.hellzic.bean.ArtisteBean;
import org.springframework.stereotype.Component;

@Component
public class ArtisteMapper {

    public ArtisteBean mapToArtisteBean(Artiste artiste) {
        return new ArtisteBean()
                .id(artiste.id())
                .label(artiste.label().toUpperCase());
    }

    public Artiste mapToArtiste(ArtisteBean artisteBean) {
        return new Artiste()
                .id(artisteBean.id())
                .label(artisteBean.label().toUpperCase());
    }

    public Artiste mapToArtiste(ArtisteBean artisteBean, String id) {
        return mapToArtiste(artisteBean)
                .id(Long.parseLong(id));
    }

}
