package com.countrytable.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {

    @JsonProperty("status")
    private int code;

    @JsonProperty("message")
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
