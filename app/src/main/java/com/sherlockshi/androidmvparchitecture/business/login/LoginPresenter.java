package com.sherlockshi.androidmvparchitecture.business.login;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Francis on 2017-2-7.
 */
public class LoginPresenter  implements LoginContract.IPresenter {
    private static final String TAG = "LoginPresenter";
    private Context mContext;
    private LoginContract.IView mView;

    public LoginPresenter(Context mContext, LoginContract.IView iView) {
        this.mContext = mContext;
        this.mView = iView;
    }

    @Override
    public void login(String loginName, String loginPsw) {

        if (TextUtils.isEmpty(loginName)){
//            mView.showMessage("用户名不能为空!");
            mView.showNoUserName(false);
            return;
        }
        mView.showNoUserName(true);
        if (TextUtils.isEmpty(loginPsw)){
//            mView.showMessage("密码不能为空!");
            mView.showNoPassWord(false);
            return;
        }
        mView.showNoPassWord(true);
        mView.goToMainActivity();
    }

    public void testJsoup(){

        Observable.create(new Observable.OnSubscribe<Document>() {
            @Override
            public void call(Subscriber<? super Document> subscriber) {
                try {
                    Document document= Jsoup.connect("https://www.zhihu.com/").get();
                    subscriber.onNext(document);
                    subscriber.onCompleted();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<Document>() {
            @Override
            public void call(Document document) {
                Log.i(TAG, "call: "+document.toString());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        });

    }
}
