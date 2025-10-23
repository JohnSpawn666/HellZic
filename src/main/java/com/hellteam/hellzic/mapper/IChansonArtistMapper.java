package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.chansonartist.ChansonArtist;
import com.hellteam.hellzic.bean.ChansonArtistBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IChansonArtistMapper {

    @Mapping(target = "chansonArtistId.chansonId", source = "bean.chansonId")
    @Mapping(target = "chansonArtistId.artistId", source = "bean.artistId")
    ChansonArtist mapToChansonArtist(ChansonArtistBean bean);

}
