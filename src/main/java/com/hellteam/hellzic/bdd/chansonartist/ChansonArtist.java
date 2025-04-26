package com.hellteam.hellzic.bdd.chansonartist;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
@Entity
public class ChansonArtist {

    @EmbeddedId
    private ChansonArtistId chansonArtistId;

}
