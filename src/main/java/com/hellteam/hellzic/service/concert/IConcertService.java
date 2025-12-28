package com.hellteam.hellzic.service.concert;

import com.hellteam.hellzic.bean.ConcertBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.NotFoundValueDatabaseException;
import com.hellteam.hellzic.error.TechnicalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IConcertService {

    ConcertBean create(ConcertBean bean) throws DuplicateException, TechnicalException, NotFoundValueDatabaseException;

    ConcertBean update(ConcertBean bean, String id) throws TechnicalException, NoneException;

    ConcertBean select(String id) throws NoneException;

    List<ConcertBean> findByLabel(String label);

    void delete(Long id);
}
