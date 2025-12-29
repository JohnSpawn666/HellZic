package com.hellteam.hellzic.bdd.artistedition;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ArtistEdition {

    @EmbeddedId
    private ArtistEditionId artistEditionId;


}
