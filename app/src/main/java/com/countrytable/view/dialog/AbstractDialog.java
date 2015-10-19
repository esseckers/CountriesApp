package com.countrytable.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.countrytable.view.Utils;

import butterknife.ButterKnife;

public abstract class AbstractDialog extends Dialog {
    private static AbstractDialog prevDialog;
    private Activity activity;
    private boolean isFullScreen;
    private boolean isCanceled = true;

    public AbstractDialog(Activity context) {
        super(context);
        this.activity = context;
    }

    public void setIsFullScreen(boolean isFullScreen) {
        this.isFullScreen = isFullScreen;
    }

    public void setIsCanceled(boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    @Override
    public void show() {
        if (prevDialog != null && prevDialog.isShowing()) {
            prevDialog.dismiss();
        }
        super.show();
        prevDialog = this;
        if (!isFullScreen) getWindow().setAttributes(Utils.dialogSize(prevDialog, activity));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setCancelable(isCanceled);
        setCanceledOnTouchOutside(isCanceled);
        setContentView(getContentView());
        ButterKnife.bind(this);
        initView();
    }

    protected void initView() {
    }

    protected abstract View getContentView();

}
