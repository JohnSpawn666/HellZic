package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.AlbumBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.service.album.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumServiceImpl service;

    @PostMapping("/create")
    AlbumBean createAlbum(@RequestBody AlbumBean bean) {
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

    @PutMapping("/update/{id}")
    AlbumBean updateAlbum(@RequestBody AlbumBean bean, @PathVariable("id") String id) {
        try {
            return service.updateAlbum(bean, id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
        }
    }

    @GetMapping("select/{id}")
    AlbumBean selectAlbum(@PathVariable("id") String id) {
        try {
            return service.selectAlbum(id);
        } catch (NoneException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    List<AlbumBean> findAlbumsByLabel(@RequestParam("label") String label) {
        return service.findByLabel(label);
    }

}
