package com.ans.dailylogtracker.piano.repository;

import com.ans.dailylogtracker.piano.model.WeeklyLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WeeklyLogRepository extends MongoRepository<WeeklyLog, String>, CustomWeeklyLogRepository {
  Optional<WeeklyLog> findByUserIdAndWeekId(String userId, Integer weekId);
}
