package com.hellteam.hellzic.mapper;

import com.hellteam.hellzic.model.CapitalizeUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface IMapper {

    @Named("capitalizeEachWords")
    static String capitalizeEachWords(String label) {
        return CapitalizeUtil.capitalizeEachWord(label.toLowerCase());
    }

}
