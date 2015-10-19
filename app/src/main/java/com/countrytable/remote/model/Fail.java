package com.countrytable.remote.model;

public class Fail {
    private String message;

    private Exception exception;

    public Fail(String message, Exception e) {
        this.message = message;
        this.exception = e;
    }

    public Fail(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Exception getException() {
        return exception;
    }
}
