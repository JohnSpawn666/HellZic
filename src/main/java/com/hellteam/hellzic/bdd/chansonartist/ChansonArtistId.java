package com.hellteam.hellzic.bdd.chansonartist;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ChansonArtistId implements Serializable {

    @Column(name = "chanson_id")
    private Long chansonId;

    @Column(name = "artist_id")
    private Long artistId;

}
