package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.ArtistEditionBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.service.artistedition.ArtistEditionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/artistedition")
public class ArtistEditionController implements IControl<ArtistEditionBean> {

    ArtistEditionServiceImpl service;

    public ArtistEditionController(ArtistEditionServiceImpl service) {
        this.service = service;
    }

    @Override
    public ArtistEditionBean create(ArtistEditionBean artistEditionBean) {
        try {
            return service.create(artistEditionBean);
        } catch (DuplicateException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        }
    }

    @Override
    public ArtistEditionBean update(ArtistEditionBean artistEditionBean, String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ArtistEditionBean select(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ArtistEditionBean> findByLabel(String label) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException();
    }
}
