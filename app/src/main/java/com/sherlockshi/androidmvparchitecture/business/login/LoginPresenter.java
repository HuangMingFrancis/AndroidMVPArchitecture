package com.sherlockshi.androidmvparchitecture.business.login;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by Francis on 2017-2-7.
 */
public class LoginPresenter implements LoginContract.IPresenter {
    private Context mContext;
    private LoginContract.IView iView;

    public LoginPresenter(Context mContext, LoginContract.IView iView) {
        this.mContext = mContext;
        this.iView = iView;
    }

    @Override
    public void login(String loginName, String loginPsw) {
        if (TextUtils.isEmpty(loginName)){
            iView.showMessage("用户名不能为空!");
            return;
        }
        if (TextUtils.isEmpty(loginPsw)){
            iView.showMessage("密码不能为空!");
            return;
        }
        iView.goToMainActivity();
    }
}
