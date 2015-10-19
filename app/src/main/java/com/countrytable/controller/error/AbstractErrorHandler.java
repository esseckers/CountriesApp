package com.countrytable.controller.error;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.view.View;

import com.countrytable.R;
import com.countrytable.remote.model.Fail;
import com.countrytable.view.dialog.ErrorDialog;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractErrorHandler implements ErrorHandler {
    private static final String TAG = "Fail";
    protected Activity activity;
    private ErrorDialog errorDialog;
    protected Set<ErrorHandlerListener> handlerListeners = new HashSet<ErrorHandlerListener>();

    protected AbstractErrorHandler(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void handleFail(Fail fail) {
        manageLoadDialog(false);
        if (fail != null) {
            Log.d(TAG, fail.getMessage());
            showDialog(activity.getString(R.string.dialog_title_warning), activity.getString(R.string.dialog_cause_no_inet), null);
        }
    }

    @Override
    public void handleError(String error) {
        manageLoadDialog(false);
        showDialog(activity.getString(R.string.dialog_title_info), error);
    }

    @Override
    public void manageLoadDialog(boolean show) {
        manageLoadDialog(show, null);
    }

    @Override
    public void addListener(ErrorHandlerListener errorHandlerListener) {
        handlerListeners.add(errorHandlerListener);
    }

    @Override
    public void removeListener(ErrorHandlerListener errorHandlerListener) {
        handlerListeners.remove(errorHandlerListener);
    }

    public void showDialog(String title, String message) {
        showDialog(title, message, null);
    }

    public void showDialog(String title, String message, final Dialog.OnClickListener listener) {
        errorDialog = new ErrorDialog(activity);
        errorDialog.setTitle(title);
        errorDialog.setCause(message);
        errorDialog.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(errorDialog, v.getId());
                }
                errorDialog.dismiss();
            }
        });
        errorDialog.show();
    }

    protected void fireProgressDialogShow(boolean show) {
        for (ErrorHandlerListener handlerListener : handlerListeners) {
            handlerListener.progressDialogShow(show);
        }
    }
}