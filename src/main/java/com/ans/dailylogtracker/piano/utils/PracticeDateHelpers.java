package com.ans.dailylogtracker.piano.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.*;

public class PracticeDateHelpers {

    public static Integer toWeekId(LocalDate date) {
        return date.get(WeekFields.of(DayOfWeek.FRIDAY, 7).weekOfWeekBasedYear());
    }

    public static String toDay(LocalDate date) {
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }


    public static LocalDate todaysDate() {
        return LocalDate.now();
    }

    public static LocalDateTime timeNow() {
        return LocalDateTime.now();
    }

    public static List<DayOfWeek> sortDays(DayOfWeek logStartDay) {
        List<DayOfWeek> list = Arrays.asList(DayOfWeek.values());
        Collections.sort(list, new Comparator<DayOfWeek>() {

            @Override
            public int compare(DayOfWeek o1, DayOfWeek o2) {
                return 0;
            }
        });

        return list;
    }
}
