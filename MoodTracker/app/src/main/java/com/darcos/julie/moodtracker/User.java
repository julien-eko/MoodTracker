package com.darcos.julie.moodtracker;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

        moodComment = new ArrayList();
        mood = new ArrayList();


    }
    public void update(){
        ArrayList<Date> lastList=listDate(lastDay,Calendar.getInstance().getTime());

        for(int i = 0;i < lastList.size(); i++) {
            if(lastList.get(i).after(dateMinuit(lastList.get(i))))
                this.moodComment.add(this.dayComment);
                this.mood.add(this.dayMood);
                this.dayComment=null;
                this.dayMood=null;

        }
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

    public String getDate() {
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
        String s = f.format(d);
        return s;
    }

    public Date getDate1() {
        Date d = new Date(2018,12,21);

        return d;
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
