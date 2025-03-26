package com.hellteam.hellzic.bdd.chanson;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface accèdant à la table Chanson
 */
public interface IChansonRepository extends JpaRepository<Chanson, Long> {

    List<Chanson> findByLabelContaining(String label);

}
