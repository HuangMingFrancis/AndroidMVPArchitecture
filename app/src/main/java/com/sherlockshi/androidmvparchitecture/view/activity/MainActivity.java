package com.sherlockshi.androidmvparchitecture.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sherlockshi.androidmvparchitecture.base.BaseActivity;
import com.sherlockshi.androidmvparchitecture.R;
import com.sherlockshi.androidmvparchitecture.business.cook_detail.CookDetailContract;
import com.sherlockshi.androidmvparchitecture.business.cook_detail.CookDetailPresenter;
import com.sherlockshi.androidmvparchitecture.global.Config;
import com.sherlockshi.androidmvparchitecture.model.entity.CookDetail;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements CookDetailContract.IView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private int id = 23;

    private static final String TAG = "MainActivity";

    private CookDetailPresenter presenter;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void initViewsAndEvents() {
        initView();
        initData();
    }

    @Override
    protected int getOverridePendingTransitionMode() {
        return BaseActivity.FADE;
    }

    @Override
    protected void DetoryViewAndThing() {

    }

    private void initView() {
        setSupportActionBar(toolbar);
    }

    private void initData() {
        presenter = new CookDetailPresenter(MainActivity.this, this);
        presenter.getCookDetail(Config.API_KEY, (id++) + "");

//        Person p2 = new Person();
//        p2.setName("lucky");
//        p2.setAddress("北京海淀");
//        p2.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId,BmobException e) {
//                if(e==null){
//                    Toaster.showShort(MainActivity.this,"添加数据成功，返回objectId为："+objectId);
//                }else{
//                    Toaster.showShort(MainActivity.this,"创建数据失败：" + e.getMessage());
//                }
//            }
//        });
    }

    @Override
    public void updateCookDetail(CookDetail cookDetail) {
        tvName.setText(cookDetail.getName());
        Picasso.with(this).load(Config.IMAGE_URL_PREFIX + cookDetail.getImg()).into(ivImage);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.fab)
    public void onClick() {
        Toast.makeText(MainActivity.this, "id: " + id, Toast.LENGTH_SHORT).show();
        presenter.getCookDetail(Config.API_KEY, (id++) + "");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
