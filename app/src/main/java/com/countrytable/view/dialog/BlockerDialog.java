package com.countrytable.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.countrytable.R;

import butterknife.Bind;

public class BlockerDialog extends AbstractDialog {

    private Context context;

    @Bind(R.id.bar)
    ImageView bar;

    public BlockerDialog(Activity context) {
        super(context);
        this.context = context;
    }

    @Override
    public void setIsCanceled(boolean isCanceled) {
        super.setIsCanceled(false);
    }

    @Override
    public void setIsFullScreen(boolean isFullScreen) {
        super.setIsFullScreen(true);
    }

    @Override
    protected void initView() {
        Animation myAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_progress);
        bar.setAnimation(myAnimation);
        bar.startAnimation(myAnimation);
    }

    @Override
    protected View getContentView() {
        return getLayoutInflater().inflate(R.layout.dialog_progress, null);
    }

    @Override
    public void show() {
        if (!this.isShowing()) {
            super.show();
        }
    }
}
