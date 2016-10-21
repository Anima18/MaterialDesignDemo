package com.example.chris.materialdesigndemo.util;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Chris on 2015/9/2.
 */
@SuppressLint("SimpleDateFormat")
public class DateUtil {
	private static final int FIRST_DAY = Calendar.MONDAY;

	public static String toString(Date date, String pattern) {
		final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.format(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date toDate(String str, String fromPattern) {
		try {
			return (new SimpleDateFormat(fromPattern)).parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

    public static Date createDate(Date date, int seconds) {
          Calendar c = Calendar. getInstance();
          c.setTime(date);
          c.add(Calendar. SECOND, seconds);          
          return c.getTime();
    }

    public static Date addDay(Date date, int day) {
    	Calendar c = Calendar. getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }
    
	public static String toString(String str, String fromPattern, String toPattern ) {
		try {
			if(StringUtil.isNotEmpty(str)) {
				Date d = (new SimpleDateFormat(fromPattern)).parse(str);
				return (new SimpleDateFormat(toPattern)).format(d);
			}
			return null;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	private static void setToFirstDay(Calendar calendar) {
		while (calendar.get(Calendar.DAY_OF_WEEK) != FIRST_DAY) {
			calendar.add(Calendar.DATE, -1);
		}
	}
}
