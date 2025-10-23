package com.hellteam.hellzic.model;

import com.hellteam.hellzic.bdd.artiste.Artiste;
import com.hellteam.hellzic.bdd.artiste.IArtisteRepository;
import com.hellteam.hellzic.bean.ArtisteBean;
import com.hellteam.hellzic.error.DuplicateException;
import com.hellteam.hellzic.error.NoneException;
import com.hellteam.hellzic.error.TechnicalException;
import com.hellteam.hellzic.mapper.IArtisteMapper;
import com.hellteam.hellzic.mapper.IArtisteMapperImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtisteModel {

    IArtisteRepository repository;
    IArtisteMapper artisteMapper;

    /**
     * Constructeur
     *
     * @param repository CRUD de la table Artiste
     */
    public ArtisteModel(IArtisteRepository repository) {
        this.repository = repository;
        artisteMapper = new IArtisteMapperImpl();
    }

    /**
     * Création d'un nouvel artiste
     *
     * @param artisteBean Bean représentant l'artiste
     * @return Bean sauvegardé
     * @throws TechnicalException ID non conforme
     * @throws DuplicateException ID déjà existant
     */
    public ArtisteBean createArtiste(ArtisteBean artisteBean) throws TechnicalException, DuplicateException {
        return artisteMapper.mapToArtisteBean(saveArtiste(artisteMapper.mapToArtiste(checkValues(artisteBean))));
    }

    /**
     * Mise à jour d'un artiste
     *
     * @param artisteBean Bean représentant l'artiste
     * @param id          ID du bean déjà existant
     * @return Artiste mis à jour
     * @throws TechnicalException ID non conforme
     * @throws DuplicateException ID déjà existant
     */
    public ArtisteBean updateArtiste(ArtisteBean artisteBean, String id) throws TechnicalException, DuplicateException {
        try {
            return artisteMapper.mapToArtisteBean(repository.save(artisteMapper.mapToArtiste(artisteBean, id)));
        } catch (NumberFormatException _) {
            throw new TechnicalException("L'ID doit être un nombre");
        } catch (Exception _) {
            throw new DuplicateException("L'ID doit déjà exister");
        }
    }

    /**
     * Enregistrement de l'artiste
     *
     * @param artiste Bean à enregistrer
     * @return Bean enregistré
     * @throws DuplicateException Artiste déjà existant
     */
    private Artiste saveArtiste(Artiste artiste) throws DuplicateException {
        try {
            return repository.save(artiste);
        } catch (Exception _) {
            throw new DuplicateException("L'artiste existe déjà");
        }
    }

    /**
     * Sélection d'un artiste par son id
     *
     * @param id ID de l'artiste
     * @return Bean de l'artiste
     * @throws NoneException Aucun artiste rtouvé
     */
    public ArtisteBean selectArtisteById(String id) throws NoneException {
        try {
            return artisteMapper.mapToArtisteBean(repository.getReferenceById(Long.parseLong(id)));
        } catch (Exception _) {
            throw new NoneException("Aucun artiste trouvé avec l'id " + id);
        }
    }

    /**
     * Recherche d'artistes par leur label
     *
     * @param label Chaine de caractère
     * @return List d'artistes contenant la chaine de caractères
     */
    public List<ArtisteBean> findByLabel(String label) {
        return repository.findByLabelContaining(label.toLowerCase()).stream()
                .map(dao -> artisteMapper.mapToArtisteBean(dao))
                .toList();
    }

    /**
     * Vérification des différents paramètres du bean Artiste
     *
     * @param artisteBean Bean à vérifier
     * @return Bean valide
     * @throws TechnicalException Erreur sur un des apramètres du bean
     */
    private ArtisteBean checkValues(ArtisteBean artisteBean) throws TechnicalException {
        CheckUtil.checkNullValues(artisteBean.label, "Le nom de l'artiste");
        return artisteBean;
    }

    /**
     * Suppression d'un artiste par son ID
     *
     * @param id ID de l'artiste à supprimer
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
