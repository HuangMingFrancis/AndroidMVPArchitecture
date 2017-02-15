package com.sherlockshi.androidmvparchitecture.view.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import com.sherlockshi.androidmvparchitecture.base.BaseActivity;
import com.sherlockshi.androidmvparchitecture.R;

import butterknife.BindView;

/**
 * Created by Francis on 2017-2-8.
 */
public class DrawerActivity extends BaseActivity {
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_drawer;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getOverridePendingTransitionMode() {
        return BaseActivity.FADE;
    }

    @Override
    protected void DetoryViewAndThing() {

    }

}
