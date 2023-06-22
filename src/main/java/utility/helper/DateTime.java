package utility.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTime {

    public static String getCurrentTime(String timeFormat) {
        return new SimpleDateFormat(timeFormat).format(Calendar.getInstance().getTime());
    }

    public static String convertDateToNewFormat(String dateStr, String oldFormat, String newFormat) throws ParseException {
        DateFormat sdf = new SimpleDateFormat(oldFormat, Locale.US);
        Date dateParse;
        String newDate = null;
        try {
            dateParse = sdf.parse(dateStr);
            newDate = (new SimpleDateFormat(newFormat)).format(dateParse);
            System.out.println(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}
