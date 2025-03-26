package com.hellteam.hellzic.service.chanson;

import com.hellteam.hellzic.bean.ChansonBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NotFoundValueDatabase;
import com.hellteam.hellzic.error.NullException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.model.ChansonModel;
import org.springframework.stereotype.Service;

@Service
public class ChansonServiceImpl implements IChansonService {

    ChansonModel chansonModel;

    public ChansonServiceImpl(ChansonModel chansonModel) {
        this.chansonModel = chansonModel;
    }

    @Override
    public ChansonBean createChanson(ChansonBean bean) throws TechnicalException, NotFoundValueDatabase, DuplicateException, NullException {
        return chansonModel.createChanson(bean);
    }
}
