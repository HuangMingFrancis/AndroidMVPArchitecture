package com.sherlockshi.androidmvparchitecture.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sherlockshi.androidmvparchitecture.util.activity.ActivityCollector;
import com.sherlockshi.androidmvparchitecture.util.animation.AnimationUtil;

/**
 * Created by Francis on 2017-2-7.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public void finish() {
        super.finish();
        AnimationUtil.pushOut(BaseActivity.this);
    }

}
