package com.hellteam.hellzic.bdd.chansonartist;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(fluent = true)
@Embeddable
public class ChansonArtistId implements Serializable {

    @Column(name = "chanson_id")
    private Long chansonId;

    @Column(name = "artist_id")
    private Long artistId;

}
