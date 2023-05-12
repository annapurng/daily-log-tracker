package com.ans.dailylogtracker.piano.model;

import com.ans.dailylogtracker.piano.common.ReviewRating;

import java.time.LocalDateTime;

public class PieceLog {
    private String pieceId;
    private String userId;
    private long duration;
    private LocalDateTime time;
    private ReviewRating reviewRating;
    private String reviewDescription="";
    private boolean practiceComplete;

    public PieceLog(String pieceId, String userId) {
        this.pieceId = pieceId;
        this.userId = userId;
        reviewRating = ReviewRating.UNRATED;
    }
    public String getPieceId() {
        return pieceId;
    }

    public void setPieceId(String pieceId) {
        this.pieceId = pieceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public ReviewRating getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(ReviewRating reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public boolean isPracticeComplete() {
        return practiceComplete;
    }

    public void setPracticeComplete(boolean practiceComplete) {
        this.practiceComplete = practiceComplete;
    }
}
