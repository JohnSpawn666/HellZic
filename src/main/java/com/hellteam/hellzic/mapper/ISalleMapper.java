package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.bdd.salle.Salle;
import com.hellteam.hellzic.bean.SalleBean;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISalleMapper extends IMapper {

    @Mapping(target = "id", source = "salleBean.id")
    @Mapping(target = "label", source = "salleBean.label")
    @Mapping(target = "departmentNumber", source = "salleBean.departmentNumber")
    Salle mapToSalle(SalleBean salleBean);

    @Mapping(target = "id", source = "salle.id")
    @Mapping(target = "label", source = "salle.label")
    @Mapping(target = "departmentNumber", source = "salle.departmentNumber")
    SalleBean mapToSalleBean(Salle salle);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "label", source = "salleBean.label")
    @Mapping(target = "departmentNumber", source = "salleBean.departmentNumber")
    Salle mapToSalle(SalleBean salleBean, String id);
}
