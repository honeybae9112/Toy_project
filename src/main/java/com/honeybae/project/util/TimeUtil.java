package com.honeybae.project.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {

    public static String get(Date time) {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = format1.format(time);
        return time1;
    }
    public static String get(Date time,String format) {
    	SimpleDateFormat format1 = new SimpleDateFormat(format);
    	format1.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
    	String time1 = format1.format(time);
    	return time1;
    }

}
