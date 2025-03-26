package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.ChansonBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NotFoundValueDatabase;
import com.hellteam.hellzic.error.NullException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.service.chanson.IChansonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
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
        } catch (NotFoundValueDatabase | DuplicateException | NullException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        } catch (TechnicalException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ChansonBean update(ChansonBean chansonBean, String id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public ChansonBean select(String id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<ChansonBean> findByLabel(String label) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
