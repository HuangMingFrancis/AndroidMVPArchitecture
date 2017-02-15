package com.francis.commonlibrary.base;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Francis on 2017-2-7.
 */
public class ActivityCollector {

    private static ActivityCollector instance = null;
    private static List<Activity> mActivities = new LinkedList<Activity>();

    private ActivityCollector() {

    }

    public static ActivityCollector getInstance() {
        if (null == instance) {
            synchronized (ActivityCollector.class) {
                if (null == instance) {
                    instance = new ActivityCollector();
                }
            }
        }
        return instance;
    }

    public int size() {
        return mActivities.size();
    }

    public synchronized Activity getForwardActivity() {
        return size() > 0 ? mActivities.get(size() - 1) : null;
    }

    public synchronized void addActivity(Activity activity) {
        mActivities.add(activity);
    }

    public synchronized void removeActivity(Activity activity) {
        if (mActivities.contains(activity)) {
            mActivities.remove(activity);
        }
    }

    public synchronized void clear() {
        for (int i = mActivities.size() - 1; i > -1; i--) {
            Activity activity = mActivities.get(i);
            removeActivity(activity);
            activity.finish();
            i = mActivities.size();
        }
    }

    public synchronized void clearToTop() {
        for (int i = mActivities.size() - 2; i > -1; i--) {
            Activity activity = mActivities.get(i);
            removeActivity(activity);
            activity.finish();
            i = mActivities.size() - 1;
        }
    }

}
