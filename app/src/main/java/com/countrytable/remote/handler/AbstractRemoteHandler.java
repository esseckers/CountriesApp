package com.countrytable.remote.handler;


import com.countrytable.remote.IRemoteServiceCallback;
import com.countrytable.remote.model.Fail;
import com.countrytable.remote.model.JSONRestResponse;

public abstract class AbstractRemoteHandler<T> extends AbstractHandler<JSONRestResponse<T>> {

    protected IRemoteServiceCallback<T> callback;

    public AbstractRemoteHandler(IRemoteServiceCallback<T> callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        fireStart();
    }

    @Override
    protected JSONRestResponse<T> doInBackground(Void... voids) {
        JSONRestResponse<T> result;
        try {
            result = super.doInBackground(voids);
        } catch (Exception e) {
            result = getFailResponse(e);
        }
        return result;
    }

    protected JSONRestResponse<T> getFailResponse(Exception e) {
        JSONRestResponse<T> result = new JSONRestResponse<T>();
        result.setFail(new Fail(e.getLocalizedMessage(), e));
        return result;
    }

    @Override
    protected void onPostExecute(JSONRestResponse<T> tServiceResponseObject) {
        super.onPostExecute(tServiceResponseObject);
        postExecute(tServiceResponseObject);
        fireFinish();
    }

    protected void postExecute(JSONRestResponse<T> tServiceResponseObject) {
        fireResult(tServiceResponseObject);
    }

    public JSONRestResponse<T> fireResult(JSONRestResponse<T> response) {
        if (callback != null) {
            if (checkSuccess(response)) {
                if (response.getResult() != null) {
                    callback.onSuccess(response.getResult());
                }
            } else if (response.getFail() != null) {
                callback.onFailure(response.getFail());
            }
        }
        return response;
    }

    /**
     * Check {@link JSONRestResponse<T>}
     *
     * @param result {@link JSONRestResponse<T>}
     * @return Return true, if {@link JSONRestResponse<T>#getEntity()} not null, false otherwise.
     */
    protected boolean checkSuccess(JSONRestResponse<T> result) {
        return result != null && result.getResult() != null;
    }

    public void fireStart() {
        if (callback != null) {
            callback.onStartTask();
        }
    }

    public void fireFinish() {
        if (callback != null) {
            callback.onFinishTask();
        }
    }
}
