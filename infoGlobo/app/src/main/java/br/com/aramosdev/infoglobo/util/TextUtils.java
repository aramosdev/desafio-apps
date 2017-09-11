package br.com.aramosdev.infoglobo.util;

import java.util.List;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class TextUtils {

    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty() || text.trim().length() == 0;
    }

    public static boolean isEmptyOrNull(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean isEmptyOrNull(Object[] array) {
        return array == null || array.length == 0;
    }
}
