package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.ArtisteBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.service.ArtisteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/artiste")
public class ArtisteController {

    @Autowired
    ArtisteServiceImpl service;

    @PostMapping("/create")
    ArtisteBean createArtiste(@RequestBody ArtisteBean artisteBean) {
        try {
            return service.createArtiste(artisteBean);
        } catch (TechnicalException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        } catch (DuplicateException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
        }
    }

    @PutMapping("/update/{id}")
    ArtisteBean updateArtiste(@RequestBody ArtisteBean artisteBean, @PathVariable("id") String id) {
        try {
            return service.updateArtiste(artisteBean, id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
        }
    }

    @GetMapping("select/{id}")
    ArtisteBean selectArtiste(@PathVariable("id") String id) {
        try {
            return service.selectArtiste(id);
        } catch (NoneException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    @GetMapping("find")
    List<ArtisteBean> findArtistsByLabel(@RequestParam("label") String label) {
        return service.findByLabel(label);
    }

}
