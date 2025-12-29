package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.artistedition.ArtistEdition;
import com.hellteam.hellzic.bean.ArtistEditionBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IArtistEditionMapper {

    @Mapping(target = "artistEditionId.artistId", source = "artistEditionBean.artistId")
    @Mapping(target = "artistEditionId.editionId", source = "artistEditionBean.editionId")
    ArtistEdition mapToArtistEdition(ArtistEditionBean artistEditionBean);

    @Mapping(target = "artistId", source = "artistEdition.artistEditionId.artistId")
    @Mapping(target = "editionId", source = "artistEdition.artistEditionId.editionId")
    ArtistEditionBean mapToArtistEditionBean(ArtistEdition artistEdition);
}
