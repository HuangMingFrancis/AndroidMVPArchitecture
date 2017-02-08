package com.sherlockshi.androidmvparchitecture.util.animation;

import android.app.Activity;

import com.sherlockshi.androidmvparchitecture.R;


/**
 * Author: Felix Shi
 * Date:   2016-03-28 16:27
 * Description: 动画工具类
 */
public class AnimationUtil {

    public static void pushIn(Activity activity) {
        // 设置切换动画，从右边进入，左边退出
        activity.overridePendingTransition(R.anim.in_from_right,
                R.anim.out_to_left);
    }

    public static void pushOut(Activity activity) {
        // 设置切换动画，从左边进入，右边退出
        activity.overridePendingTransition(R.anim.in_from_left,
                R.anim.out_to_right);
    }
}
