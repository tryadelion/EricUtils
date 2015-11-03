/*
 * Copyright (c) 2015.  made by CptEric.The code, comments and names are under the Creative Commons liscence.
 */

package com.software.cpteric.ericutils;

import android.util.Log;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.software.cpteric.ericutils.StringUtils.isValid;

/**
 * Created by useit on 3/11/15.
 */
public class DateUtils {

    public static Date getDateFromString(String dateString) {
        return getDateFromString(dateString,null);
    }

    public static Date getDateFromString(String dateString,String format) {
        //1978-03-16T00:00:00
        String defaultFormat = "yyyy-MM-dd'T'HH:mm:ss";
        if(!isValid(format)) {
            format = defaultFormat;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            Log.e("DateUtils",e.toString());
        }
        Log.e("DateUtils",convertedDate.toString());
        return convertedDate;
    }

    public static String getStringFromDate(Date date) {
        return getStringFromDate(date,null);
    }

    public static String getStringFromDate(Date date,String format) {
        String defaultFormat = "yyyy-MM-dd'T'HH:mm:ss";
        if(!isValid(format)) {
            format = defaultFormat;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String convertedDate;
        convertedDate = dateFormat.format(date);
        System.out.println(convertedDate);
        return convertedDate;
    }
    public static String getAgeFromDate(Date date) {
        Calendar today = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date2.setTime(date);
        int age = today.get(Calendar.YEAR) - date2.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < date2.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = age;

        return ageInt.toString();
    }

    private static String getMonth(int month, Locale locale) {
        return DateFormatSymbols.getInstance(locale).getMonths()[month];
    }

    public static String getMonthName(Date date) {
        Locale locale = Locale.getDefault();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getMonth(cal.get(Calendar.MONTH), locale);
    }

    public static boolean isEarlier(Date d1,Date d2) {
        if (d1 == null || d2 == null) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        if (cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR)) {
            return true;
        }
        else if (cal1.get(Calendar.DAY_OF_YEAR) < cal2.get(Calendar.DAY_OF_YEAR)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static String getTimeFromDate(Date date) {
        String str = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        str =  dateFormat.format(date);
        return str;
    }

}
