package com.deromang.daggersample.ui;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * Created by Iria Sanchez on 2019-06-17.
 */
public class DisplayUtil {
    public DisplayUtil() {
    }

    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5F);
    }

    public static int px2dp(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5F);
    }

    public static Point getScreenSize(Context context) {
        Point point = new Point();
        WindowManager wm = (WindowManager)context.getSystemService("window");
        wm.getDefaultDisplay().getSize(point);
        return point;
    }
}