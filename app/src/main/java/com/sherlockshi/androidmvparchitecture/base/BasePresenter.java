package com.sherlockshi.androidmvparchitecture.base;

import android.content.Context;

/**
 * Created by Francis on 2017-2-15.
 */

public abstract class BasePresenter<T> {
    public Context mContext;
    public T mView;
}
