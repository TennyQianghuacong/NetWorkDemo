package com.tenny.networkdemo.utils;

import android.app.Activity;
import android.os.Build;

/**
 * Created by TennyQ on 12/23/20
 */
public class SystemUtils {

    /**
     * 判断Activity是否销毁
     * @param activity
     * @return
     */
    public static boolean isHostValidate(Activity activity) {
        if (activity == null) {
            return true;
        }

        if (activity.isFinishing()) {
            return true;
        }

        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && activity.isDestroyed();
    }

}
