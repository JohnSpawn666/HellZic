package com.hellteam.hellzic.bdd.chansonartist;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ChansonArtist {

    @EmbeddedId
    private ChansonArtistId chansonArtistId;

}
