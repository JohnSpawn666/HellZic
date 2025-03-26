package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.AlbumBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.service.album.AlbumServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/album")
public class AlbumController implements IControl<AlbumBean> {

    AlbumServiceImpl service;

    public AlbumController(AlbumServiceImpl service) {
        this.service = service;
    }

    @Override
    public AlbumBean create(@RequestBody AlbumBean bean) {
        try {
            return service.createAlbum(bean);
        } catch (TechnicalException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        } catch (DuplicateException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
        }
    }

    @Override
    public AlbumBean update(@RequestBody AlbumBean bean, @PathVariable("id") String id) {
        try {
            return service.updateAlbum(bean, id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
        }
    }

    @Override
    public AlbumBean select(@PathVariable("id") String id) {
        try {
            return service.selectAlbum(id);
        } catch (NoneException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    @Override
    public List<AlbumBean> findByLabel(@RequestParam("label") String label) {
        return service.findByLabel(label);
    }

    @Override
    public void delete(Long id) {
        service.deleteById(id);
    }

}
