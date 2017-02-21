package com.sherlockshi.androidmvparchitecture.view.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.francis.commonlibrary.utils.Toaster;
import com.sherlockshi.androidmvparchitecture.R;
import com.sherlockshi.androidmvparchitecture.base.BaseActivity;
import com.sherlockshi.androidmvparchitecture.business.login.LoginContract;
import com.sherlockshi.androidmvparchitecture.business.login.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Francis on 2017-2-7.
 */
public class LoginActivity extends BaseActivity implements LoginContract.IView {
    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_login_name)
    EditText etLoginName;
    @BindView(R.id.et_login_psw)
    EditText etLoginPsw;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.text_input_login)
    TextInputLayout textInputLogin;
    @BindView(R.id.text_input_psw)
    TextInputLayout textInputPsw;

    private LoginPresenter presenter;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void initViewsAndEvents() {
        initData();
    }

    @Override
    protected int getOverridePendingTransitionMode() {
        return BaseActivity.FADE;
    }

    @Override
    protected void DetoryViewAndThing() {
        Toaster.closeToast();
    }

    private void initData() {
        presenter = new LoginPresenter(mContext, this);
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
        readyGoThenKill(DrawerActivity.class);
    }

    @Override
    public void showNoUserName(boolean isValue) {
        if (isValue){
            textInputLogin.setError(null);
        }else{
            textInputLogin.setError("账号不能为空!");
        }
    }

    @Override
    public void showNoPassWord(boolean isValue) {
        if (isValue){
            textInputPsw.setError(null);
        }else{
            textInputPsw.setError("密码不能为空!");
        }
    }


    @OnClick({R.id.btn_register, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
//                Toaster.showShort(LoginActivity.this, "register");
                presenter.testJsoup();
                break;
            case R.id.btn_login:
                presenter.login(etLoginName.getText().toString(), etLoginPsw.getText().toString());
                break;
        }
    }

}
