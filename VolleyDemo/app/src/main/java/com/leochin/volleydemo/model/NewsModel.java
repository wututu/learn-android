package com.leochin.volleydemo.model;

import java.util.ArrayList;

/**
 * Created by wenhao on 8/20/15.
 */
public class NewsModel {

    private String date;
    private ArrayList<DailyNewsModel> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<DailyNewsModel> getStories() {
        return stories;
    }

    public void setStories(ArrayList<DailyNewsModel> stories) {
        this.stories = stories;
    }
}
