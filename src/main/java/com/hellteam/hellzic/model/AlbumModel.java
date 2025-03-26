package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.album.Album;
import com.hellteam.hellzic.bdd.album.IAlbumRepository;
import com.hellteam.hellzic.bean.AlbumBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.mapper.AlbumMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlbumModel {

    IAlbumRepository repository;

    AlbumMapper mapper;

    public AlbumModel(IAlbumRepository repository) {
        this.repository = repository;
        mapper = new AlbumMapper();
    }

    public AlbumBean createAlbum(AlbumBean bean) throws TechnicalException, DuplicateException {
        return mapper.mapToAlbumBean(saveAlbum(mapper.mapToAlbumEntity(checkValues(bean))));
    }

    public AlbumBean updateAlbum(AlbumBean bean, String id) throws TechnicalException, NoneException {
        try {
            return mapper.mapToAlbumBean(repository.save(mapper.mapToAlbumEntity(bean, id)));
        } catch (NumberFormatException ex) {
            throw new TechnicalException("L'id doit être un nombre");
        } catch (Exception ex) {
            throw new NoneException("L'id doit exister");
        }
    }

    private Album saveAlbum(Album album) throws DuplicateException {
        try {
            return repository.save(album);
        } catch (Exception ex) {
            throw new DuplicateException("L'album existe déjà");
        }
    }

    public AlbumBean selectAlbum(String id) throws NoneException {
        try {
            return mapper.mapToAlbumBean(repository.getReferenceById(Long.parseLong(id)));
        } catch (Exception ex) {
            throw new NoneException("Aucun album trouvé avec l'id " + id);
        }
    }

    public List<AlbumBean> findByLabel(String label) {
        return repository.findByLabelContaining(CapitalizeUtil.capitalizeEachWord(label.toLowerCase())).stream()
                .map(dao -> mapper.mapToAlbumBean(dao))
                .toList();
    }


    private AlbumBean checkValues(AlbumBean bean) throws TechnicalException {
        CheckUtil.checkNullValues(bean.label, "Le nom de l'album");
        return bean;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
