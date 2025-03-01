package com.hellteam.hellzic.service.artiste;

import com.hellteam.hellzic.bean.ArtisteBean;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IArtisteService {

    ArtisteBean createArtiste(ArtisteBean artisteBean) throws Exception;

    ArtisteBean updateArtiste(ArtisteBean artisteBean, String id) throws TechnicalException, NoneException;

    ArtisteBean selectArtiste(String id) throws NoneException;

    List<ArtisteBean> findByLabel(String label);
}
