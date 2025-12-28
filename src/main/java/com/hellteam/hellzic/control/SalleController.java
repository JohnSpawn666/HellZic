package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.SalleBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.service.salle.SalleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("salle")
public class SalleController implements IControl<SalleBean> {

    SalleServiceImpl service;

    public SalleController(SalleServiceImpl service) {
        this.service = service;
    }

    @Override
    public SalleBean create(@RequestBody SalleBean salleBean) {

        try {
            return service.createSalle(salleBean);
        } catch (TechnicalException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        } catch (DuplicateException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        }
    }

    @Override
    public SalleBean update(SalleBean salleBean, String id) {
        try {
            return service.updateSalle(salleBean, id);
        } catch (TechnicalException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        } catch (DuplicateException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        }
    }

    @Override
    public SalleBean select(String id) {
        try {
            return service.selectSalle(id);
        } catch (NoneException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    @Override
    public List<SalleBean> findByLabel(String label) {
        return service.findByLabel(label);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
