package com.ans.dailylogtracker.piano.model;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "WeeklyLog")
@CompoundIndexes({ @CompoundIndex(name = "yearweek", def = "{'year' : 1, 'weekId': 1, 'userId': 1}") })
public class WeeklyLog {
    @Indexed(direction = IndexDirection.ASCENDING)
    private Integer weekId;
    @Indexed(direction = IndexDirection.ASCENDING)
    private Integer year;
    List<DailyLog> dailyLogs;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String userId;

    public Integer getWeekId() {
        return weekId;
    }

    public void setWeekId(Integer weekId) {
        this.weekId = weekId;
    }

    public List<DailyLog> getDailyLogs() {
        return dailyLogs;
    }

    public void setDailyLogs(List<DailyLog> dailyLogs) {
        this.dailyLogs = dailyLogs;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
