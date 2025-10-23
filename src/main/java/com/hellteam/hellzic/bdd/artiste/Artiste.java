package com.hellteam.hellzic.bdd.artiste;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Artiste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "label")
    private String label;

}
