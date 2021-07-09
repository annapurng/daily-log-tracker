package com.ans.dailylogtracker.piano.exception;

public class LogTrackerException extends RuntimeException{
    public LogTrackerException() {
    }

    public LogTrackerException(String message) {
        super(message);
    }

    public LogTrackerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogTrackerException(Throwable cause) {
        super(cause);
    }

    public LogTrackerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
