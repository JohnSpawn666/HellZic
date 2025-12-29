package com.hellteam.hellzic.bean;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EditionBean {

    private Long id;
    private Long festivalId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String endroit;

}
