package com.ans.dailylogtracker.piano.model;

import com.ans.dailylogtracker.piano.common.CMLevel;
import com.ans.dailylogtracker.piano.model.CMProgram;
import com.mongodb.lang.NonNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    @NonNull
    private String userId;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private LocalDate dateJoined;
    private LocalDateTime lastLoginTime;

    private CMLevel level;

    @NonNull
    private CMProgram program;

    private String pictureUrl;
    private DayOfWeek logStartDay;
    private int logDaysInWeek = 7;

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public CMLevel getLevel() {
        return level;
    }

    public void setLevel(CMLevel level) {
        this.level = level;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public DayOfWeek getLogStartDay() {
        return logStartDay;
    }

    public void setLogStartDay(DayOfWeek logStartDay) {
        this.logStartDay = logStartDay;
    }

    public CMProgram getProgram() {
        return program;
    }

    public void setProgram(CMProgram program) {
        this.program = program;
    }
}
