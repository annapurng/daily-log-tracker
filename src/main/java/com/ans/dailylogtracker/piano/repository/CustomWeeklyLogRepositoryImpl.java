package com.ans.dailylogtracker.piano.repository;

import com.ans.dailylogtracker.piano.exception.LogTrackerException;
import com.ans.dailylogtracker.piano.model.DailyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.DayOfWeek;
import java.util.List;

public class CustomWeeklyLogRepositoryImpl implements CustomWeeklyLogRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public DailyLog findDailyLog(String userId, Integer weekId, DayOfWeek dayOfWeek) {
        Criteria userWeekCriteria = Criteria.where("weekId").is(weekId)
                .and("userId").is(userId);
        Criteria dayOfWeekCriteria = Criteria.where("dailyLogs").elemMatch(Criteria.where("dayOfWeek").is(dayOfWeek.toString()));
        List<DailyLog> dailyLogList =  mongoTemplate.find(new Query().addCriteria(new Criteria().andOperator(userWeekCriteria, dayOfWeekCriteria)),
                DailyLog.class);
        if (dailyLogList.isEmpty()) {
            throw new LogTrackerException("Failed to find log for user " + userId + " week " + weekId + " day " + dayOfWeek);
        }
        if (dailyLogList.size() > 1) {
            throw new LogTrackerException("Failed to find unique log for user " + userId + " week " + weekId + " day " + dayOfWeek);
        }

        return dailyLogList.get(0);
    }
}
