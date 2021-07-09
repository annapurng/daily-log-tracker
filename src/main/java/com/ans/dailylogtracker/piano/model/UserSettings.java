package com.ans.dailylogtracker.piano.model;

import com.ans.dailylogtracker.piano.common.CMLevel;

import java.time.LocalDateTime;
import java.util.List;

public class UserSettings {
    private String id;
    CMLevel cmLevel;
    LocalDateTime lastLogTime;
    List<Piece> pieceList;

}
