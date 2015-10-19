package com.countrytable.view.dialog;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.countrytable.R;

import butterknife.Bind;

public class ErrorDialog extends AbstractDialog {

    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Bind(R.id.tv_cause)
    TextView tvCause;

    @Bind(R.id.btn_ok)
    Button btnOk;

    private String title;
    private String cause;
    private View.OnClickListener listener;

    public ErrorDialog(Activity context) {
        super(context);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    protected void initView() {
        if (title != null) tvTitle.setText(title);
        if (cause != null) tvCause.setText(cause);
        if (listener != null) btnOk.setOnClickListener(listener);
    }

    @Override
    protected View getContentView() {
        return getLayoutInflater().inflate(R.layout.dialog_no_connect, null);
    }
}


