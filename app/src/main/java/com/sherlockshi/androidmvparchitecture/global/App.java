package com.sherlockshi.androidmvparchitecture.global;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogTool;
import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.sherlockshi.androidmvparchitecture.model.storage.sql.greenDAO.DaoMaster;
import com.sherlockshi.androidmvparchitecture.model.storage.sql.greenDAO.DaoSession;
import com.squareup.leakcanary.LeakCanary;

import org.greenrobot.greendao.database.Database;

import cn.bmob.v3.Bmob;

/**
 * Author: SherlockShi
 * Date:   2016-10-26 10:59
 * Description:
 */

public class App extends Application {

    public static Context mContext;

    private DaoSession daoSession;
    //判断数据库是否加密
    public static final boolean ENCRYPTED = true;

    @Override public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);


        mContext = this;

        //Stetho.initializeWithDefaults(this);

        initLogger();


        initDataBase();
        initBomb();
    }

    //初始化数据库
    private void initDataBase() {
        //设置数据库
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(this,ENCRYPTED ? Constants.GreenDAO.databaseNameEncryted : Constants.GreenDAO.databaseName);
        Database database=ENCRYPTED ? helper.getEncryptedWritableDb(Constants.GreenDAO.passWord) : helper.getWritableDb();
        daoSession=new DaoMaster(database).newSession();
    }

    //初始化Bomb
    private void initBomb() {
        //第一：默认初始化
        Bmob.initialize(this, Constants.Bomb.applicationId);

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config);
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Logger.init("AndroidMVPArchitecture")   // default PRETTYLOGGER or use just init()
                    .methodCount(3)                 // default 2
                    .hideThreadInfo()               // default shown
                    .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                    .methodOffset(0)                // default 0
                    .logTool(new AndroidLogTool()); // custom log tool, optional
        } else {
            Logger.init("AndroidMVPArchitecture")   // default PRETTYLOGGER or use just init()
                    .methodCount(3)                 // default 2
                    .hideThreadInfo()               // default shown
                    .logLevel(LogLevel.NONE)        // default LogLevel.FULL
                    .methodOffset(0)                // default 0
                    .logTool(new AndroidLogTool()); // custom log tool, optional
        }
    }
}
