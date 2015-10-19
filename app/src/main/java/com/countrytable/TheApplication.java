package com.countrytable;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class TheApplication extends Application {

    private static TheApplication sApplication;
    private SharedPreferences sharedPreferences;

    public static TheApplication getInstance() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public SharedPreferences getPreferences() {
        if (sharedPreferences == null) {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        }
        return sharedPreferences;
    }
}
