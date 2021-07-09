package com.ans.dailylogtracker.piano.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Resource not found")
public class LogTrackerNotFoundException extends RuntimeException{
    public LogTrackerNotFoundException() {
    }

    public LogTrackerNotFoundException(String message) {
        super(message);
    }

    public LogTrackerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogTrackerNotFoundException(Throwable cause) {
        super(cause);
    }

    public LogTrackerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
