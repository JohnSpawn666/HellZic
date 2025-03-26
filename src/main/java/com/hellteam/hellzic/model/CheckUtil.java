package com.hellteam.hellzic.model;

import com.hellteam.hellzic.error.TechnicalException;
import org.springframework.util.StringUtils;

public class CheckUtil {

    public static void checkNullValues(String label, String prefixError) throws TechnicalException {
        if (!StringUtils.hasLength(label)) {
            throw new TechnicalException(prefixError + " n'est pas renseigné");
        }
    }
}
