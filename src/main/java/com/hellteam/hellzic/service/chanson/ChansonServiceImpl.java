package com.hellteam.hellzic.service.chanson;

import com.hellteam.hellzic.bean.ChansonBean;
import com.hellteam.hellzic.error.*;
import com.hellteam.hellzic.model.ChansonModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChansonServiceImpl implements IChansonService {

    ChansonModel model;

    public ChansonServiceImpl(ChansonModel model) {
        this.model = model;
    }

    @Override
    public ChansonBean createChanson(ChansonBean bean) throws TechnicalException, NotFoundValueDatabaseException, DuplicateException, NullException {
        return model.createChanson(bean);
    }

    @Override
    public ChansonBean updateChanson(ChansonBean chansonBean, String id) throws TechnicalException, NoneException {
        return model.updateChanson(chansonBean, id);
    }

    @Override
    public ChansonBean selectChanson(String id) throws NoneException {
        return model.selectChansonById(id);
    }

    @Override
    public List<ChansonBean> findByLabel(String label) {
        return model.findByLabel(label);
    }

    @Override
    public void delete(Long id) {
        model.deleteById(id);
    }
}
