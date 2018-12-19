package com.darcos.julie.moodtracker;

import java.util.ArrayList;

public class User {

    private ArrayList<String> moodComment;
    private ArrayList<Integer> moodDay;
    private static User instance = new User();

    public static User getInstance(){
        return instance;
    }
    private User(){

        moodComment = new ArrayList();
        moodDay = new ArrayList();

    }

    public ArrayList<String> getMoodComment() {
        return moodComment;
    }

    public void addMoodComment(String Comment) {
        this.moodComment.add(Comment);
    }

    public ArrayList<Integer> getMoodDay() {
        return moodDay;
    }

    public void addMoodDay(Integer moodDay) {
        this.moodDay.add(moodDay);
    }
}
