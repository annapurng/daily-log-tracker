package com.ans.dailylogtracker.piano.repository;

import com.ans.dailylogtracker.piano.model.DailyLog;

import java.time.DayOfWeek;

public interface CustomWeeklyLogRepository {
    DailyLog findDailyLog(String userId, Integer weekId, DayOfWeek dayOfWeek);
}

