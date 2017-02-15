package com.sherlockshi.androidmvparchitecture.business.login;

import android.content.Context;
import android.text.TextUtils;

import com.sherlockshi.androidmvparchitecture.base.BasePresenter;

/**
 * Created by Francis on 2017-2-7.
 */
public class LoginPresenter extends BasePresenter<LoginContract.IView> implements LoginContract.IPresenter {

    public LoginPresenter(Context mContext, LoginContract.IView iView) {
        this.mContext = mContext;
        this.mView = iView;
    }

    @Override
    public void login(String loginName, String loginPsw) {

        if (TextUtils.isEmpty(loginName)){
            mView.showMessage("用户名不能为空!");
            return;
        }
        if (TextUtils.isEmpty(loginPsw)){
            mView.showMessage("密码不能为空!");
            return;
        }
        mView.goToMainActivity();
    }
}
