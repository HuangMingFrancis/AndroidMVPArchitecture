package com.sherlockshi.androidmvparchitecture.business.login;

import com.sherlockshi.androidmvparchitecture.base.presenter.IBasePresenter;
import com.sherlockshi.androidmvparchitecture.base.view.IBaseView;

/**
 * Created by Francis on 2017-2-7.
 */
public interface LoginContract {
    interface IView extends IBaseView{
        void goToMainActivity();
        void showNoUserName(boolean isValue);
        void showNoPassWord(boolean isValue);
    }

    interface IPresenter extends IBasePresenter{
        void login(String loginName,String loginPsw);
    }
}
