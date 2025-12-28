package com.hellteam.hellzic.service.salle;

import com.hellteam.hellzic.bean.SalleBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.model.SalleModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements ISalleService {

    SalleModel model;

    public SalleServiceImpl(SalleModel model) {
        this.model = model;
    }

    @Override
    public SalleBean createSalle(SalleBean salle) throws TechnicalException, DuplicateException {
        return model.createSalle(salle);
    }

    @Override
    public SalleBean updateSalle(SalleBean salleBean, String id) throws TechnicalException, DuplicateException {
        return model.updateSalle(salleBean, id);
    }

    @Override
    public SalleBean selectSalle(String id) throws NoneException {
        return model.selectSalle(id);
    }

    @Override
    public List<SalleBean> findByLabel(String label) {
        return model.findByLabel(label);
    }

    @Override
    public void delete(Long id) {
        model.delete(id);
    }
}
