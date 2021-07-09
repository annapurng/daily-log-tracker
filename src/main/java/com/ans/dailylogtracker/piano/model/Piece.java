package com.ans.dailylogtracker.piano.model;

import com.ans.dailylogtracker.piano.common.CMLevel;
import com.ans.dailylogtracker.piano.common.Period;
import com.ans.dailylogtracker.piano.common.PieceType;

import java.time.LocalDate;
import java.util.Date;

public class Piece  extends Object{
    private String pieceId;
    private PieceType pieceType;
    private String name;
    private String composer;
    private Period period;
    private LocalDate compositionDate;
    private CMLevel cmLevel;
    private boolean active;

    public String getPieceId() {
        return pieceId;
    }

    public void setPieceId(String pieceId) {
        this.pieceId = pieceId;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public LocalDate getCompositionDate() {
        return compositionDate;
    }

    public void setCompositionDate(LocalDate compositionDate) {
        this.compositionDate = compositionDate;
    }

    public CMLevel getCmLevel() {
        return cmLevel;
    }

    public void setCmLevel(CMLevel cmLevel) {
        this.cmLevel = cmLevel;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
