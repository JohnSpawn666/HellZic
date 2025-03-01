package com.hellteam.hellzic.service.album;

import com.hellteam.hellzic.bean.AlbumBean;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.model.AlbumModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
    AlbumModel model;

    @Override
    public AlbumBean createAlbum(AlbumBean bean) throws Exception {
        return model.createAlbum(bean);
    }

    @Override
    public AlbumBean updateAlbum(AlbumBean bean, String id) throws TechnicalException, NoneException {
        return model.updateAlbum(bean, id);
    }

    @Override
    public AlbumBean selectAlbum(String id) throws NoneException {
        return model.selectAlbum(id);
    }

    @Override
    public List<AlbumBean> findByLabel(String label) {
        return model.findByLabel(label);
    }
}
