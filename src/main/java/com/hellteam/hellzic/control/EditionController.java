package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.EditionBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.service.edition.EditionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/edition")
public class EditionController implements IControl<EditionBean> {

    EditionServiceImpl service;

    public EditionController(EditionServiceImpl service) {
        this.service = service;
    }

    @Override
    public EditionBean create(EditionBean editionBean) {
        try {
            return service.create(editionBean);
        } catch (TechnicalException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (DuplicateException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        }
    }

    @Override
    public EditionBean update(EditionBean editionBean, String id) {
        try {
            return service.update(editionBean, id);
        } catch (TechnicalException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @Override
    public EditionBean select(String id) {
        return service.select(id);
    }

    @Override
    public List<EditionBean> findByLabel(@RequestParam("endroit") String endroit) {
        return service.findByEndroit(endroit);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
