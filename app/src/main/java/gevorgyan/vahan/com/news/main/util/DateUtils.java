package gevorgyan.vahan.com.news.main.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateUtils {

    private static final String DATE_TIME_FORMAT_READABLE = "dd MMM yy HH:mm";

    private DateUtils() {
    }

    public static String getFormattedDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT_READABLE, Locale.getDefault());
        return formatter.format(date);
    }

}
