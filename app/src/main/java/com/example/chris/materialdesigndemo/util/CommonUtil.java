package com.example.chris.materialdesigndemo.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by Admin on 2016/7/24.
 */
public class CommonUtil {
    public static Context getApplicationContext() {
        return MyApplication.getInstance();
    }

    public static int dipToPixels(float dipValue) {
        DisplayMetrics metrics = getApplicationContext().getResources().getDisplayMetrics();
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }
}
