package com.darcos.julie.moodtracker;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class User {

    private ArrayList<String> moodComment;
    private ArrayList<String> mood;
    private static User instance = new User();
    private String dayComment="";
    private String dayMood="";
    private Date lastDay;



    public static User getInstance(){
        return instance;
    }
    private User(){


    }



//return everyday between strat date and end date
    public static ArrayList<Date> listDate(Date start, Date end){
        ArrayList<Date> list =new ArrayList<Date>();
        Calendar dateStart=Calendar.getInstance();
        Calendar dateEnd=Calendar.getInstance();
        dateStart.setTime(start);
        dateEnd.setTime(end);
        dateEnd.add(Calendar.DAY_OF_YEAR,1);

        while (dateStart.before(dateEnd)==true){
            list.add(dateStart.getTime());
            dateStart.add(Calendar.DAY_OF_YEAR,1);
        }
        return list;
    }

    //return the date at 00:00
    public static Date dateMinuit(Date d1){
        int d=d1.getDate();
        int y=d1.getYear();
        int m=d1.getMonth();

        return new Date(y,m,d+1);
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


    public String getDayComment() {
        return dayComment;
    }

    public void setDayComment(String dayComment) {
        this.dayComment = dayComment;
    }

    public String getDayMood() {
        return dayMood;
    }

    public void setDayMood(String dayMood) {
        this.dayMood = dayMood;
    }
}
