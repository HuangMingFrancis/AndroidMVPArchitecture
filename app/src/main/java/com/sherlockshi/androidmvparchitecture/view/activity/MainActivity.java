package com.sherlockshi.androidmvparchitecture.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sherlockshi.androidmvparchitecture.R;
import com.sherlockshi.androidmvparchitecture.base.BaseActivity;
import com.sherlockshi.androidmvparchitecture.business.cook_detail.CookDetailContract;
import com.sherlockshi.androidmvparchitecture.business.cook_detail.CookDetailPresenter;
import com.sherlockshi.androidmvparchitecture.global.Config;
import com.sherlockshi.androidmvparchitecture.model.entity.CookDetail;
import com.sherlockshi.androidmvparchitecture.model.entity.MessageEvent;
import com.sherlockshi.androidmvparchitecture.model.entity.Person;
import com.sherlockshi.androidmvparchitecture.util.Toaster;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

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
    private CookDetailPresenter mCookDetailPresenter;

    private int id = 23;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();


    }


    @Override
    protected void onResume() {
        super.onResume();
        initData();
        initEventBus();
    }

    private void initEventBus() {
//        EventBus.getDefault().post(new MessageEvent("天气","天气很好","Francis.Huang"));
    }

    private void initView() {
        setSupportActionBar(toolbar);
    }

    private void initData() {
        mCookDetailPresenter = new CookDetailPresenter(MainActivity.this, this);
        mCookDetailPresenter.getCookDetail(Config.API_KEY, (id++) + "");


        Person p2 = new Person();
        p2.setName("lucky");
        p2.setAddress("北京海淀");
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    Toaster.showShort(MainActivity.this,"添加数据成功，返回objectId为："+objectId);
                }else{
                    Toaster.showShort(MainActivity.this,"创建数据失败：" + e.getMessage());
                }
            }
        });
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
        mCookDetailPresenter.getCookDetail(Config.API_KEY, (id++) + "");
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        tvName.setText(event.getAuthor());
        Log.i(TAG, "onMessageEvent: "+event.getTitle()+" "+event.getContent()+" "+event.getAuthor());
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
