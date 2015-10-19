package com.countrytable;

import retrofit.RestAdapter;

public class Environment {

    public static final String SERVER = "http://beta.taxistock.ru/taxik/api/client";
    public static final RestAdapter.LogLevel LOG_LEVEL = RestAdapter.LogLevel.FULL;
}
