package br.com.aramosdev.infoglobo.util;

import com.google.gson.Gson;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class AppUtils {

    private static Gson gson;


    public static Gson getGson() {
        if (gson == null) gson = new Gson();
        return gson;
    }
}
