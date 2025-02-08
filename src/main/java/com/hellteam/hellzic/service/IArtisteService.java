package com.hellteam.hellzic.service;

import com.hellteam.hellzic.bean.ArtisteBean;
import org.springframework.stereotype.Service;

@Service
public interface IArtisteService {

    ArtisteBean createArtiste(ArtisteBean artisteBean) throws Exception;

}
