package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.FestivalBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.service.festival.FestivalServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/festival")
public class FestivalController implements IControl<FestivalBean> {

    FestivalServiceImpl service;

    public FestivalController(FestivalServiceImpl service) {
        this.service = service;
    }

    @Override
    public FestivalBean create(FestivalBean festivalBean) {
        try {
            return service.create(festivalBean);
        } catch (TechnicalException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (DuplicateException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        }
    }

    @Override
    public FestivalBean update(FestivalBean festivalBean, String id) {
        try {
            return service.update(festivalBean, id);
        } catch (TechnicalException | NoneException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (DuplicateException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        }
    }

    @Override
    public FestivalBean select(String id) {
        return service.select(id);
    }

    @Override
    public List<FestivalBean> findByLabel(String label) {
        return service.findByLabel(label);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
