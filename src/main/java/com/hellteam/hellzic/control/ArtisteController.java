package com.hellteam.hellzic.control;

import com.hellteam.hellzic.bean.ArtisteBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.service.ArtisteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/artiste")
public class ArtisteController {

    @Autowired
    ArtisteServiceImpl service;

    @PostMapping("/create")
    ArtisteBean createArtiste(@RequestBody ArtisteBean artisteBean) {
        try {
            return service.createArtiste(artisteBean);
        } catch (Exception ex) {
            if (ex instanceof TechnicalException) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
            } else if (ex instanceof DuplicateException) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
            }
        }

    }

}
