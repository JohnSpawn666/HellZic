package com.hellteam.hellzic.bdd.festival;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "label")
    private String label;

}
