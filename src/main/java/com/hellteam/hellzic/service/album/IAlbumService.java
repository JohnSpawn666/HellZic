package com.hellteam.hellzic.service.album;

import com.hellteam.hellzic.bean.AlbumBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAlbumService {

    AlbumBean createAlbum(AlbumBean album) throws TechnicalException, DuplicateException;

    AlbumBean updateAlbum(AlbumBean album, String id) throws TechnicalException, NoneException;

    AlbumBean selectAlbum(String id) throws NoneException;

    List<AlbumBean> findByLabel(String label);

    void deleteById(Long id);
}
