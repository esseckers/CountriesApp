package com.countrytable.controller.error;

import android.app.Activity;

import com.countrytable.remote.model.Fail;
import com.countrytable.view.dialog.BlockerDialog;


public class ActivityErrorHandler extends AbstractErrorHandler {

    private BlockerDialog blockerDialog;

    public ActivityErrorHandler(Activity activity) {
        super(activity);
    }

    @Override
    public void handleError(String error) {
        super.handleError(error);
    }

    @Override
    public void handleFail(Fail fail) {
        super.handleFail(fail);
    }

    @Override
    public void manageLoadDialog(boolean show, String message) {
        if (blockerDialog == null) {
            blockerDialog = new BlockerDialog(activity);
        }
        if (show && !blockerDialog.isShowing()
                && activity != null && !activity.isFinishing()) {
            fireProgressDialogShow(true);
            blockerDialog.show();
        }
        if (!show && blockerDialog.isShowing()
                && activity != null && !activity.isFinishing()) {
            blockerDialog.dismiss();
            fireProgressDialogShow(false);
        }
    }
}
