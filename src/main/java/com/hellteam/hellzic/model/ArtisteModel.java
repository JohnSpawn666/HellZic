package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.artiste.Artiste;
import com.hellteam.hellzic.bdd.artiste.IArtisteRepository;
import com.hellteam.hellzic.bean.ArtisteBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.mapper.ArtisteMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtisteModel {

    IArtisteRepository repository;

    ArtisteMapper mapper;

    public ArtisteModel(IArtisteRepository repository, ArtisteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ArtisteBean createArtiste(ArtisteBean artisteBean) throws TechnicalException, DuplicateException {
        return mapper.mapToArtisteBean(saveArtiste(mapper.mapToArtiste(checkValues(artisteBean))));
    }

    public ArtisteBean updateArtiste(ArtisteBean artisteBean, String id) throws TechnicalException, NoneException {
        try {
            return mapper.mapToArtisteBean(repository.save(mapper.mapToArtiste(artisteBean, id)));
        } catch (NumberFormatException ex) {
            throw new TechnicalException("L'ID doit être un nombre");
        } catch (Exception ex) {
            throw new NoneException("L'ID doit déjà exister");
        }
    }

    private Artiste saveArtiste(Artiste artiste) throws DuplicateException {
        try {
            return repository.save(artiste);
        } catch (Exception ex) {
            throw new DuplicateException("L'artiste existe déjà");
        }
    }

    public ArtisteBean selectArtiste(String id) throws NoneException {
        try {
            return mapper.mapToArtisteBean(repository.getReferenceById(Long.parseLong(id)));
        } catch (Exception ex) {
            throw new NoneException("Aucun artiste trouvé avec l'id " + id);
        }
    }

    public List<ArtisteBean> findByLabel(String label) {
        return repository.findByLabelContaining(label.toUpperCase()).stream()
                .map(dao -> mapper.mapToArtisteBean(dao))
                .toList();
    }

    private ArtisteBean checkValues(ArtisteBean artisteBean) throws TechnicalException {
        CheckUtil.checkNullValues(artisteBean.label, "Le nom de l'artiste");
        return artisteBean;
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
