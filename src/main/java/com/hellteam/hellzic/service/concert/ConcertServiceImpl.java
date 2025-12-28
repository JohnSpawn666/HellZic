package com.hellteam.hellzic.service.concert;

import com.hellteam.hellzic.bean.ConcertBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.NotFoundValueDatabaseException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.model.ConcertModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertServiceImpl implements IConcertService {

    ConcertModel model;

    public ConcertServiceImpl(ConcertModel model) {
        this.model = model;
    }

    @Override
    public ConcertBean create(ConcertBean bean)
            throws DuplicateException, TechnicalException, NotFoundValueDatabaseException {
        return model.create(bean);
    }

    @Override
    public ConcertBean update(ConcertBean bean, String id) throws TechnicalException, NoneException {
        return model.update(bean, id);
    }

    @Override
    public ConcertBean select(String id) throws NoneException {
        return model.select(id);
    }

    @Override
    public List<ConcertBean> findByLabel(String label) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Long id) {
        model.delete(id);
    }
}
