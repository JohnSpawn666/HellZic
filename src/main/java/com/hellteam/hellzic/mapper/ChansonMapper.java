package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.chanson.Chanson;
import com.hellteam.hellzic.bean.ChansonBean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ChansonMapper {

    public Chanson mapToChansonEntity(ChansonBean bean) {
        return new Chanson()
                .label(StringUtils.capitalize(bean.titre().toLowerCase()))
                .albumId(bean.albumId());
    }

    public ChansonBean mapToChansonBean(Chanson entity) {
        return new ChansonBean()
                .id(entity.id())
                .titre(StringUtils.capitalize(entity.label().toLowerCase()))
                .albumId(entity.albumId());
    }
}
