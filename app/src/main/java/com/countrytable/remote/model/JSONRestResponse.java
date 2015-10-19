package com.countrytable.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JSONRestResponse<T> {

    @JsonProperty("cities")
    private T result;

    private Fail fail;

    public T getResult() {
        return result;
    }

    public Fail getFail() {
        return fail;
    }

    public void setFail(Fail fail) {
        this.fail = fail;
    }
}
