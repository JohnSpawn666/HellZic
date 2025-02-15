package com.hellteam.hellzic.bdd.artiste;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface accédant à la table Artiste
 */
public interface IArtisteRepository extends JpaRepository<Artiste, Long> {
    
    List<Artiste> findByLabelContaining(String label);

}
