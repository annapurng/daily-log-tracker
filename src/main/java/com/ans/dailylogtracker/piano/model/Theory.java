package com.ans.dailylogtracker.piano.model;

import com.ans.dailylogtracker.piano.common.CMLevel;

public class Theory {
    private String id;
    private User user;
    private CMLevel cmLevel;
    private int chapter;
    private String notes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CMLevel getCmLevel() {
        return cmLevel;
    }

    public void setCmLevel(CMLevel cmLevel) {
        this.cmLevel = cmLevel;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
