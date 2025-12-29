package com.hellteam.hellzic.service.edition;

import com.hellteam.hellzic.bean.EditionBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.model.EditionModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionServiceImpl implements IEditionService {

    EditionModel model;

    public EditionServiceImpl(EditionModel model) {
        this.model = model;
    }

    @Override
    public EditionBean create(EditionBean editionBean) throws TechnicalException, DuplicateException {
        return model.create(editionBean);
    }

    @Override
    public EditionBean update(EditionBean editionBean, String id) throws TechnicalException {
        return model.update(editionBean, id);
    }

    @Override
    public EditionBean select(String id) {
        return model.select(id);
    }

    @Override
    public List<EditionBean> findByEndroit(String endroit) {
        return model.findByEndroit(endroit);
    }

    @Override
    public void delete(Long id) {
        model.delete(id);
    }
}
