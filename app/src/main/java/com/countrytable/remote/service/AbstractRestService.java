package com.countrytable.remote.service;


import com.countrytable.Environment;
import com.countrytable.remote.IService;
import com.countrytable.remote.model.JSONRestResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

public abstract class AbstractRestService<T> {
    private static IService iRestService;

    protected JSONRestResponse<T> serviceResponseObject;

    protected static IService getAPI() {
        System.setProperty("http.keepAlive", "false");
        if (iRestService == null) {
            iRestService = new RestAdapter.Builder()
                    .setEndpoint(Environment.SERVER)
                    .setConverter(new JacksonConverter(getObjectMapper()))
                    .setLogLevel(Environment.LOG_LEVEL)
                    .build()
                    .create(IService.class);
        }
        return iRestService;
    }

    protected static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper;
    }

    public JSONRestResponse<T> getServiceResponseObject() {
        return serviceResponseObject;
    }

    public void run() {
        run(getAPI());
    }

    protected abstract void run(IService API);
}
