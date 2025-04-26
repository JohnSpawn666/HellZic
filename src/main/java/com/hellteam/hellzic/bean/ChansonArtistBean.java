package com.hellteam.hellzic.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class ChansonArtistBean {

    public Long chansonId;
    public Long artistId;

}
