package com.countrytable.view;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class Utils {

    public final static String BUNDLE_KEY = "country";

    public static WindowManager.LayoutParams dialogSize(Dialog dialog, Activity activity) {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        double x = point.x * 0.8;
        lp.width = (int) x;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        return lp;
    }
}
