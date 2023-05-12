package com.ans.dailylogtracker.piano.controller;

import com.ans.dailylogtracker.piano.exception.LogTrackerException;
import com.ans.dailylogtracker.piano.model.DailyLog;
import com.ans.dailylogtracker.piano.model.PieceLog;
import com.ans.dailylogtracker.piano.model.WeeklyLog;
import com.ans.dailylogtracker.piano.repository.PieceRepository;
import com.ans.dailylogtracker.piano.repository.WeeklyLogRepository;
import com.ans.dailylogtracker.piano.utils.PracticeDateHelpers;
import com.ans.dailylogtracker.piano.utils.WeeklyLogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/practice-log")
public class PracticeLogController {
    @Autowired
    private PieceRepository pieceRepository;
    @Autowired
    private WeeklyLogRepository weeklyLogRepository;
    @Autowired
    private WeeklyLogHelper weeklyLogHelper;

    @GetMapping
    public List<WeeklyLog> getAllLogs() {
        return weeklyLogRepository.findAll();
    }

    @GetMapping(value="/current-year/weekly/{weekId}/piece/{pieceId}", produces="application/json")
    public List<PieceLog> getWeeklyLogsForPiece(@PathVariable Integer weekId, @PathVariable String pieceId, @RequestParam String userId) {
        return null;
    }

    @GetMapping(value="/current-year/weekly/{weekId}/daily/{day}", produces="application/json")
    public DailyLog getDailyLog(@PathVariable Integer weekId, @PathVariable String day, @RequestParam String userId) {
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(day);
        return weeklyLogRepository.findDailyLog(userId, weekId, dayOfWeek);
    }

    @GetMapping(value="/current-year/weeks/date/{isoDate}", produces="application/json")
    public WeeklyLog getWeeklyLogForDate(@PathVariable String isoDate, @RequestParam String userId) {
        LocalDate date = LocalDate.parse(isoDate);
        int weekId = PracticeDateHelpers.toWeekId(date);
        return getWeeklyLogForWeek(weekId, userId);
    }

    @GetMapping(value="/current-year/weeks/{weekId}", produces="application/json")
    public WeeklyLog getWeeklyLogForWeek(@PathVariable Integer weekId, @RequestParam String userId) {
        Optional<WeeklyLog> weeklyLogOptional = weeklyLogRepository.findByUserIdAndWeekId(userId, weekId);
        if (!weeklyLogOptional.isPresent()) {
            return createWeeklyLog(userId, weekId);
        }

        return  weeklyLogOptional.get();
    }

    @PutMapping(value="/current-year/weeks/{weekId}", produces="application/json", consumes="application/json")
    public WeeklyLog updateWeeklyLog(@PathVariable Integer weekId, @RequestParam String userId, @RequestBody WeeklyLog updatedWeeklyLog) {
        WeeklyLog weeklyLog = weeklyLogRepository.save(updatedWeeklyLog);

        return getWeeklyLogForWeek(weekId, userId);
    }

    @PostMapping(value="/users/{userId}/weeks/current", produces="application/json")
    public WeeklyLog newWeeklyLog(@PathVariable String userId) {
        LocalDate todaysDate = LocalDate.now();
        int weekId = PracticeDateHelpers.toWeekId(todaysDate);
        return createWeeklyLog(userId, weekId);
    }

    private WeeklyLog createWeeklyLog(String userId, Integer weekId) {

        Optional<WeeklyLog> dbLog =  weeklyLogRepository.findByUserIdAndWeekId(userId, weekId);
        if (dbLog.isPresent()) {
           return dbLog.get();
        }

        return weeklyLogRepository.save(weeklyLogHelper.createDefault(userId, weekId, LocalDate.now().getYear()));
    }
}
