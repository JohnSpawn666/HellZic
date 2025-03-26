package com.hellteam.hellzic.bdd.chanson;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
@Entity
public class Chanson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "album_id")
    private Long albumId;
}
