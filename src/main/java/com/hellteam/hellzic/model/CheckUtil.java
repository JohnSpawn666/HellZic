package com.hellteam.hellzic.model;

import com.hellteam.hellzic.error.TechnicalException;
import org.springframework.util.StringUtils;

public class CheckUtil {

    private CheckUtil() {
        // not used
    }

    /**
     * Vérifie que les valeurs ne sont pas nulles
     *
     * @param value       Valeur avec la nullité à vérifier
     * @param prefixError Préfixe du message d'erreur
     * @throws TechnicalException Valeur nulle
     */
    public static void checkNullValues(String value, String prefixError) throws TechnicalException {
        if (!StringUtils.hasLength(value)) {
            throw new TechnicalException(prefixError + " n'est pas renseigné");
        }
    }

    /**
     * Vérifie que les valeurs (en nombre) ne sont pas nulles
     *
     * @param valueInNumber Valeur en nombre avec la nullité à vérifier
     * @param prefixError   Préfixe du message d'erreur
     * @throws TechnicalException Valeur nulle
     */
    public static void checkNullValues(int valueInNumber, String prefixError) throws TechnicalException {
        checkNullValues(String.valueOf(valueInNumber), prefixError);
    }
}
