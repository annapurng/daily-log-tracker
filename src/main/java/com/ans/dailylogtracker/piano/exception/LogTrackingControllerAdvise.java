package com.ans.dailylogtracker.piano.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LogTrackingControllerAdvise {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = LogTrackerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void notFoundErrorHandler(Exception e) throws Exception {

    }
}