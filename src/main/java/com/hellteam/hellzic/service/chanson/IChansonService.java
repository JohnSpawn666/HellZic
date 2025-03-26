package com.hellteam.hellzic.service.chanson;

import com.hellteam.hellzic.bean.ChansonBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NotFoundValueDatabase;
import com.hellteam.hellzic.error.NullException;
import com.hellteam.hellzic.error.TechnicalException;
import org.springframework.stereotype.Service;

@Service
public interface IChansonService {

    ChansonBean createChanson(ChansonBean bean) throws TechnicalException, NotFoundValueDatabase, DuplicateException, NullException;
}
