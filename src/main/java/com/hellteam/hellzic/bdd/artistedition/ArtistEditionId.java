package com.hellteam.hellzic.bdd.artistedition;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ArtistEditionId implements Serializable {

    @Column(name = "artist_id")
    private Long artistId;

    @Column(name = "edition_id")
    private Long editionId;

}
