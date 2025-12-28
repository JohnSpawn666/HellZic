package com.hellteam.hellzic.bdd.salle;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "department_number")
    private int departmentNumber;

}
