package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.ChansonBean;
import com.hellteam.hellzic.error.*;
import com.hellteam.hellzic.service.chanson.IChansonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/chanson")
public class ChansonController implements IControl<ChansonBean> {

    IChansonService service;

    public ChansonController(IChansonService service) {
        this.service = service;
    }

    @Override
    public ChansonBean create(ChansonBean chansonBean) {
        try {
            return service.createChanson(chansonBean);
        } catch (NotFoundValueDatabaseException | DuplicateException | NullException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        } catch (TechnicalException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
        }
    }

    @Override
    public ChansonBean update(@RequestBody ChansonBean chansonBean, String id) {
        try {
            return service.updateChanson(chansonBean, id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
        }
    }

    @Override
    public ChansonBean select(String id) {
        try {
            return service.selectChanson(id);
        } catch (NoneException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    @Override
    public List<ChansonBean> findByLabel(@RequestParam("label") String label) {
        return service.findByLabel(label);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
