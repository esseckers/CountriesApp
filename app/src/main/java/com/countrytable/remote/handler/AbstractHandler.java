package com.countrytable.remote.handler;

import android.os.AsyncTask;

public abstract class AbstractHandler<T> extends AsyncTask<Void, Void, T> {

    @Override
    protected T doInBackground(Void... voids) {
        return executeRemoteRoutine(voids);
    }

    protected T executeRemoteRoutine(Void... voids) {
        return null;
    }
    protected T executeLocalRoutine(Void... voids) {
        return null;
    }

}
