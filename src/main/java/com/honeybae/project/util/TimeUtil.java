package com.honeybae.project.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {

	public static String getDate(Date time) {
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateformat.format(time);
	}
	public static String getDate(Date time,String format) {
		SimpleDateFormat simpleDateformat = new SimpleDateFormat(format);
		return simpleDateformat.format(time);
	}
	public static Date getDate(String time, String format) throws ParseException {
		SimpleDateFormat simpleDateformat = new SimpleDateFormat(format);
		return simpleDateformat.parse(time);
	}
	public static Date getDate(String format) throws ParseException {
		SimpleDateFormat simpleDateformat = new SimpleDateFormat(format);
		String nowDate =  simpleDateformat.format(new Date());
		return simpleDateformat.parse(nowDate);
	}

    public static String getDayCalculation(Date time, String format, int day) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(time);
    	calendar.add(Calendar.DATE, day);
    	SimpleDateFormat simpleDateformat = new SimpleDateFormat(format);
    	return simpleDateformat.format(calendar.getTime());
    }

}
