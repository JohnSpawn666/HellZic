package com.hellteam.hellzic.bdd.edition;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEditionRepository extends JpaRepository<Edition, Long> {

    List<Edition> findByEndroitContaining(String endroit);
}
