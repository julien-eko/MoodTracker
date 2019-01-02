package com.darcos.julie.moodtracker.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class User {


    private static User instance = new User();
    private String dayMood="";



    public static User getInstance(){
        return instance;
    }
    private User(){


    }

    public String dateToString(Date d) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        String s = f.format(d);
        return s;
    }

    public Date stringToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    public static Date removeOneDay(Date d){
        Calendar dateStart=Calendar.getInstance();
        dateStart.setTime(d);
        dateStart.add(Calendar.DAY_OF_YEAR,-1);

        return dateStart.getTime();
    }



    public String getDayMood() {
        return dayMood;
    }

    public void setDayMood(String dayMood) {
        this.dayMood = dayMood;
    }
}
