package com.sherlockshi.androidmvparchitecture.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sherlockshi.androidmvparchitecture.R;
import com.sherlockshi.androidmvparchitecture.base.BaseActivity;
import com.sherlockshi.androidmvparchitecture.business.login.LoginContract;
import com.sherlockshi.androidmvparchitecture.business.login.LoginPresenter;
import com.sherlockshi.androidmvparchitecture.util.Toaster;
import com.sherlockshi.androidmvparchitecture.util.animation.AnimationUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Francis on 2017-2-7.
 */
public class LoginActivity extends BaseActivity implements LoginContract.IView {
    private static final String TAG = "LoginActivity";
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.et_login_name)
    EditText etLoginName;
    @BindView(R.id.et_login_psw)
    EditText etLoginPsw;


    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        loginPresenter = new LoginPresenter(this, this);
    }

    @OnClick({R.id.btn_register, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                break;
            case R.id.btn_login:
                loginPresenter.login(etLoginName.getText().toString(), etLoginPsw.getText().toString());
                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String msg) {
        Toaster.showShort(this, msg);
    }

    @Override
    public void goToMainActivity() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        AnimationUtil.pushIn(LoginActivity.this);
        finish();
    }

}
