package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.ConcertBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.NotFoundValueDatabaseException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.service.concert.ConcertServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/concert")
public class ConcertController implements IControl<ConcertBean> {

    ConcertServiceImpl service;

    public ConcertController(ConcertServiceImpl service) {
        this.service = service;
    }

    @Override
    public ConcertBean create(ConcertBean bean) {

        try {
            return service.create(bean);
        } catch (DuplicateException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        } catch (TechnicalException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (NotFoundValueDatabaseException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @Override
    public ConcertBean update(ConcertBean concertBean, String id) {
        try {
            return service.update(concertBean, id);
        } catch (TechnicalException | NoneException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @Override
    public ConcertBean select(String id) {
        try {
            return service.select(id);
        } catch (NoneException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @Override
    public List<ConcertBean> findByLabel(String label) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
