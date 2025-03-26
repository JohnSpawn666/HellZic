package com.hellteam.hellzic.model;

public class CapitalizeUtil {

    public static String capitalizeEachWord(String str) {
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            charArray[0] = Character.toUpperCase(charArray[0]);
            if (charArray[i] == ' ') {
                charArray[i + 1] = Character.toUpperCase(charArray[i + 1]);
            }
        }
        return String.valueOf(charArray);
    }
}
