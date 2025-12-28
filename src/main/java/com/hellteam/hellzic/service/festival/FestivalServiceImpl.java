package com.hellteam.hellzic.service.festival;

import com.hellteam.hellzic.bean.FestivalBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.model.FestivalModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FestivalServiceImpl implements IFestivalService {

    FestivalModel model;

    public FestivalServiceImpl(FestivalModel model) {
        this.model = model;
    }

    @Override
    public FestivalBean create(FestivalBean festivalBean) throws TechnicalException, DuplicateException {
        return model.create(festivalBean);
    }

    @Override
    public FestivalBean update(FestivalBean festivalBean, String id) throws TechnicalException, NoneException, DuplicateException {
        return model.update(festivalBean, id);
    }

    @Override
    public FestivalBean select(String id) {
        return model.select(id);
    }

    @Override
    public List<FestivalBean> findByLabel(String label) {
        return model.findByLabel(label);
    }

    @Override
    public void delete(Long id) {
        model.delete(id);
    }
}
