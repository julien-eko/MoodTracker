package com.darcos.julie.moodtracker;

import java.util.ArrayList;

public class User {

    private ArrayList<String> moodComment;
    private ArrayList<String> mood;
    private static User instance = new User();
    private String dayComment="";
    private String dayMood="";



    public static User getInstance(){
        return instance;
    }
    private User(){

        moodComment = new ArrayList();
        mood = new ArrayList();

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
