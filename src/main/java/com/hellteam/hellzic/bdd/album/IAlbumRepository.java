package com.hellteam.hellzic.bdd.album;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByLabelContaining(String label);
}
