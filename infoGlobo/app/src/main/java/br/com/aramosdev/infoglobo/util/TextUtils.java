package br.com.aramosdev.infoglobo.util;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class TextUtils {

    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty() || text.trim().length() == 0;
    }

}
