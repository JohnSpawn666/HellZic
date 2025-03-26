package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.chanson.Chanson;
import com.hellteam.hellzic.bean.ChansonBean;
import com.hellteam.hellzic.model.CapitalizeUtil;
import org.springframework.stereotype.Component;

@Component
public class ChansonMapper {

    public Chanson mapToChanson(ChansonBean bean) {
        return new Chanson()
                .label(bean.titre().toLowerCase())
                .albumId(bean.albumId());
    }

    public Chanson mapToChanson(ChansonBean bean, String id) {
        return mapToChanson(bean)
                .id(Long.parseLong(id));
    }

    public ChansonBean mapToChansonBean(Chanson entity) {
        return new ChansonBean()
                .id(entity.id())
                .titre(CapitalizeUtil.capitalizeEachWord(entity.label().toLowerCase()))
                .albumId(entity.albumId());
    }
}
