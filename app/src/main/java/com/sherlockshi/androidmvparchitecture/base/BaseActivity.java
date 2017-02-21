package com.sherlockshi.androidmvparchitecture.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.francis.commonlibrary.R;
import com.francis.commonlibrary.base.ActivityCollector;

import butterknife.ButterKnife;

/**
 * Created by Francis on 2017-2-7.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext = null;
    public static final int LEFT = 1, RIGHT = 2, TOP = 3, BOTTOM = 4, SCALE = 5, FADE = 6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        switch (getOverridePendingTransitionMode()) {
            case LEFT:
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case RIGHT:
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
                break;
            case TOP:
                overridePendingTransition(R.anim.top_in, R.anim.top_out);
                break;
            case BOTTOM:
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                break;
            case SCALE:
                overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
                break;
            case FADE:
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            default:
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
        }
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getBundleExtras(extras);
        }

        mContext = this;
        ActivityCollector.getInstance().addActivity(this);
        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
            ButterKnife.bind(this);
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        initViewsAndEvents();
    }

    @Override
    public void finish() {
        super.finish();
        ActivityCollector.getInstance().removeActivity(this);
        switch (getOverridePendingTransitionMode()) {
            case LEFT:
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case RIGHT:
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
                break;
            case TOP:
                overridePendingTransition(R.anim.top_in, R.anim.top_out);
                break;
            case BOTTOM:
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                break;
            case SCALE:
                overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
                break;
            case FADE:
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            default:
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // 当新设置中，屏幕布局模式为横排时
        if (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            //TODO 某些操作
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DetoryViewAndThing();
    }

    /**
     * startActivity
     *
     * @param clazz
     */
    protected void readyGo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz
     */
    protected void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz
     * @param requestCode
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    protected abstract int getContentViewLayoutID();

    protected abstract void getBundleExtras(Bundle extras);

    protected abstract void initViewsAndEvents();

    protected abstract int getOverridePendingTransitionMode();

    protected abstract void DetoryViewAndThing();


}
