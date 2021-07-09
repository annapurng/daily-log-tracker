package com.ans.dailylogtracker.piano.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.util.List;

@Document(collection = "DailyLog")
public class DailyLog {
    private String userId;
    List<PieceLog> pieceLogs;
    private Integer weekId;
    private DayOfWeek dayOfWeek;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<PieceLog> getPieceLogs() {
        return pieceLogs;
    }

    public void setPieceLogs(List<PieceLog> pieceLogs) {
        this.pieceLogs = pieceLogs;
    }

    public Integer getWeekId() {
        return weekId;
    }

    public void setWeekId(Integer weekId) {
        this.weekId = weekId;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
