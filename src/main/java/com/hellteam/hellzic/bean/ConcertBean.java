package com.hellteam.hellzic.bean;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ConcertBean {

    private Long id;
    private Long salleId;
    private Long artistId;
    private LocalDate dateConcert;

}
