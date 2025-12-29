package com.hellteam.hellzic.service.edition;

import com.hellteam.hellzic.bean.EditionBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.TechnicalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEditionService {

    EditionBean create(EditionBean editionBean) throws TechnicalException, DuplicateException;

    EditionBean update(EditionBean editionBean, String id) throws TechnicalException;

    EditionBean select(String id);

    List<EditionBean> findByEndroit(String endroit);

    void delete(Long id);
}
