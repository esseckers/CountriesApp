package com.countrytable.remote;

import android.os.AsyncTask;

import com.countrytable.model.Country;
import com.countrytable.remote.handler.CountriesHandler;

import java.util.List;

public class RemoteManager {

    public static AsyncTask getCountries(IRemoteServiceCallback<List<Country>> callback) {
        return new CountriesHandler(callback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
