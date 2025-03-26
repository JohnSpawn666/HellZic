package com.hellteam.hellzic.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
@SuppressWarnings("")
public class AlbumBean {

    public Long id;
    public String label;

}
