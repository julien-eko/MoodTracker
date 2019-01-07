package com.darcos.julie.moodtracker.Model;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class User {

    //singleton because they are one user
    private static User instance = new User();
    private String dayMood = "";


    public static User getInstance() {
        return instance;
    }

    private User() {


    }

    //convert date in string
    public String dateToString(Date d) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        return f.format(d);
    }

    //convert string in date
    public Date stringToDate(String date) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    //removed one day at the date and set at 00:00
    public static Date removeOneDay(Date d) {
        Calendar dateStart = Calendar.getInstance();
        dateStart.setTime(d);
        dateStart.add(Calendar.DAY_OF_YEAR, -1);

        return dateStart.getTime();
    }


    public String getDayMood() {
        return dayMood;
    }

    public void setDayMood(String dayMood) {
        this.dayMood = dayMood;
    }
}
