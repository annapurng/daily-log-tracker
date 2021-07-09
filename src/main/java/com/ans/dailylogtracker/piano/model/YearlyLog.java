package com.ans.dailylogtracker.piano.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "YearlyLog")
public class YearlyLog {
    private String userId;
    private int year;
    private List<String> weeklyLogIds;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getWeeklyLogIds() {
        return weeklyLogIds;
    }

    public void setWeeklyLogIds(List<String> weeklyLogIds) {
        this.weeklyLogIds = weeklyLogIds;
    }
}
