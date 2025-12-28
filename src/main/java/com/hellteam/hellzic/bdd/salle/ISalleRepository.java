package com.hellteam.hellzic.bdd.salle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface accédant à la table SALLE
 */
public interface ISalleRepository extends JpaRepository<Salle, Long> {

    List<Salle> findByLabelContaining(String label);

}
