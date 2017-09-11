package br.com.aramosdev.infoglobo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public class DateUtils {

    private static final Locale ptBR = new Locale("pt", "BR");
    private static final java.text.DateFormat formatterTimezone
            = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());

    public static String formatDateTimeTimezone(String dateStr) {
        Date date;
        try {
            date = DateUtils.formatterTimezone.parse(dateStr);
        } catch (Exception e) {
            return null;
        }

        return DateUtils.getFormattedString("dd/MM/yyyy 'às' HH:mm 'hrs'", date).toLowerCase();
    }

    public static String getFormattedString(String format, Date date){
        java.text.DateFormat formatterOut = new SimpleDateFormat(format, DateUtils.ptBR);

        return date != null ? String.valueOf(formatterOut.format(date)).toUpperCase() : null;
    }
}
