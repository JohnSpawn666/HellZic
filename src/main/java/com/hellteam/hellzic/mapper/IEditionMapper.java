package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.edition.Edition;
import com.hellteam.hellzic.bean.EditionBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IEditionMapper {

    @Mapping(target = "id", source = "editionBean.id")
    @Mapping(target = "festivalId", source = "editionBean.festivalId")
    @Mapping(target = "dateDebut", source = "editionBean.dateDebut")
    @Mapping(target = "dateFin", source = "editionBean.dateFin")
    @Mapping(target = "endroit", source = "editionBean.endroit")
    Edition mapToEdition(EditionBean editionBean);

    @Mapping(target = "id", source = "edition.id")
    @Mapping(target = "festivalId", source = "edition.festivalId")
    @Mapping(target = "dateDebut", source = "edition.dateDebut")
    @Mapping(target = "dateFin", source = "edition.dateFin")
    @Mapping(target = "endroit", source = "edition.endroit")
    EditionBean mapToEditionBean(Edition edition);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "festivalId", source = "editionBean.festivalId")
    @Mapping(target = "dateDebut", source = "editionBean.dateDebut")
    @Mapping(target = "dateFin", source = "editionBean.dateFin")
    @Mapping(target = "endroit", source = "editionBean.endroit")
    Edition mapToEdition(EditionBean editionBean, String id);
}
