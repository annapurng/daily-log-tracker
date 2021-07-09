package com.ans.dailylogtracker.piano.api;

import com.ans.dailylogtracker.piano.model.PieceLog;
import com.ans.dailylogtracker.piano.model.WeeklyLog;

import java.util.List;
import java.util.Map;

public interface PracticeLogApi {
    WeeklyLog getWeeklyLogForPiece(Integer weekId, String userId, String pieceId);
    List<PieceLog> getDailyLog(String userId, String isoDate);
    Map<String, List<PieceLog>> getPracticeLogsForWeek(String userId, String isoDate);
    Map<String, List<PieceLog>> getPracticeLogsForWeek(String userId, Integer weekId);
    PieceLog updatePracticeLog(String userId, String pieceId, PieceLog log);
}
