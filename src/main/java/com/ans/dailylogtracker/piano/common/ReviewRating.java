package com.ans.dailylogtracker.piano.common;

public enum ReviewRating {
    EXCELLENT(5), GOOD(4), OK(3), ACCEPTABLE(2), NOT_ENOUGH(1);

    private final int numStars;


    private ReviewRating(int level) {
        this.numStars = level;
    }
}
