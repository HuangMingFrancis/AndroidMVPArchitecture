package com.sherlockshi.androidmvparchitecture.view.activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.sherlockshi.androidmvparchitecture.R;
import com.sherlockshi.androidmvparchitecture.base.BaseActivity;

import io.codetail.animation.ViewAnimationUtils;

/**
 * Created by Francis on 2017-2-17.
 */

public class SplashActivity extends BaseActivity {
    private boolean hasAnimationStarted;
    private boolean loadDataCompleted = true;
    private boolean showAnimationCompleted = false;
    private boolean activityStarted = false;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getOverridePendingTransitionMode() {
        return 0;
    }

    @Override
    protected void DetoryViewAndThing() {

    }

    private void initSplash() {
        View myView = findViewById(R.id.awesome_card);

        // get the center for the clipping circle
        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;

        // get the final radius for the clipping circle
        int dx = Math.max(cx, myView.getWidth() - cx);
        int dy = Math.max(cy, myView.getHeight() - cy);
        float finalRadius = (float) Math.hypot(dx, dy);

        // Android native animator
        Animator animator =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(1500);
        animator.start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                showAnimationCompleted = true;
                if (loadDataCompleted && showAnimationCompleted && !activityStarted) {
                    activityStarted = true;
                    startActivity(new Intent(SplashActivity.this, DrawerActivity.class));
                    finish();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        hasAnimationStarted = true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && !hasAnimationStarted) {
            initSplash();
        }
    }
}
