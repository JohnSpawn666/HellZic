package com.hellteam.hellzic.bdd.festival;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFestivalRepository extends JpaRepository<Festival, Long> {

    List<Festival> findByLabelContaining(String label);
}
