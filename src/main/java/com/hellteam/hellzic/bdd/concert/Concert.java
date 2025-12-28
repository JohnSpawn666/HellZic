package com.hellteam.hellzic.bdd.concert;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "salle_id")
    private Long salleId;

    @Column(name = "artist_id")
    private Long artistId;

    @Column(name = "date_concert")
    private LocalDate dateConcert;

}
