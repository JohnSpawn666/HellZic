package com.hellteam.hellzic.service.festival;

import com.hellteam.hellzic.bean.FestivalBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFestivalService {

    FestivalBean create(FestivalBean festivalBean) throws TechnicalException, DuplicateException;

    FestivalBean update(FestivalBean festivalBean, String id) throws TechnicalException, NoneException, DuplicateException;

    FestivalBean select(String id);

    List<FestivalBean> findByLabel(String label);

    void delete(Long id);
}
