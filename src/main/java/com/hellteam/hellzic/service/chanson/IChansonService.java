package com.hellteam.hellzic.service.chanson;

import com.hellteam.hellzic.bean.ChansonBean;
import com.hellteam.hellzic.error.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IChansonService {

    ChansonBean createChanson(ChansonBean bean) throws TechnicalException, NotFoundValueDatabaseException, DuplicateException, NullException;

    ChansonBean updateChanson(ChansonBean chansonBean, String id) throws TechnicalException, NoneException;

    ChansonBean selectChanson(String id) throws NoneException;

    List<ChansonBean> findByLabel(String label);

    void delete(Long id);
}
