package com.hellteam.hellzic.bdd.chanson;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface accèdant à la table Chanson
 */
public interface IChansonRepository extends JpaRepository<Chanson, Long> {
}
