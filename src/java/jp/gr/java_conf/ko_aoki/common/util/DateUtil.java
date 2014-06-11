package jp.gr.java_conf.ko_aoki.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private DateUtil(){};

    public static String formatDateString(String date) {
        if ( date == null || "99999999".equals(date)) {
            return "";
        }
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        try {
            cal.set(Integer.parseInt(date.substring(0,4)), Integer.parseInt(date.substring(4,6)) - 1, Integer.parseInt(date.substring(6)));
            return sdt.format(cal.getTime());
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String getFormatCurDateString() {
	    Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    return sdf.format(date);
    }
}
