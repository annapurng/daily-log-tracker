package com.ans.dailylogtracker.piano.utils;

import com.ans.dailylogtracker.piano.exception.LogTrackerException;
import com.ans.dailylogtracker.piano.exception.LogTrackerNotFoundException;
import com.ans.dailylogtracker.piano.model.DailyLog;
import com.ans.dailylogtracker.piano.model.Piece;
import com.ans.dailylogtracker.piano.model.PieceLog;
import com.ans.dailylogtracker.piano.model.WeeklyLog;
import com.ans.dailylogtracker.piano.repository.UserRepository;
import com.ans.dailylogtracker.piano.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class WeeklyLogHelper {
    @Autowired
    private UserRepository userRepository;

    public WeeklyLog createDefault(String userId, Integer weekId, int year) {
        WeeklyLog weeklyLog = new WeeklyLog();
        weeklyLog.setUserId(userId);
        weeklyLog.setWeekId(weekId);
        weeklyLog.setYear(LocalDate.now().getYear());
        weeklyLog.setDailyLogs(createDefaultDailyLogs(userId, weekId));
        return weeklyLog;
    }

    private List<DailyLog> createDefaultDailyLogs(String userId, Integer weekId) {
        List<DailyLog> dailyLogs = new ArrayList<>();
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new LogTrackerNotFoundException("User " + userId + " not found");
        }
        List<Piece> pieces = userRepository.findByUserId(userId).getProgram().getPieceList();
        List<DayOfWeek> sortedDayOfWeeks = PracticeDateHelpers.sortDays(user.getLogStartDay());
        for (DayOfWeek dayOfWeek : sortedDayOfWeeks) {
            DailyLog dailyLog = new DailyLog(user.getUserId(), weekId, dayOfWeek);
            List<PieceLog> pieceLogs = new ArrayList<>();
            for (Piece piece : pieces) {
                pieceLogs.add(createDefaultPieceLog(userId, piece));
            }
            dailyLog.setPieceLogs(pieceLogs);
            dailyLogs.add(dailyLog);
        }
        return dailyLogs;
    }

    private PieceLog createDefaultPieceLog(String userId, Piece piece) {
        PieceLog pieceLog = new PieceLog(userId, piece.getPieceId());
        return pieceLog;
    }
}
