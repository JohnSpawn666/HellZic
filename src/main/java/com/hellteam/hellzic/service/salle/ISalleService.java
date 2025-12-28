package com.hellteam.hellzic.service.salle;

import com.hellteam.hellzic.bean.SalleBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISalleService {

    SalleBean createSalle(SalleBean salle) throws TechnicalException, DuplicateException;

    SalleBean updateSalle(SalleBean salleBean, String id) throws TechnicalException, DuplicateException;

    SalleBean selectSalle(String id) throws NoneException;

    List<SalleBean> findByLabel(String label);

    void delete(Long id);

}
