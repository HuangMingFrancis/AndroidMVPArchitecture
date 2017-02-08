package com.sherlockshi.androidmvparchitecture.global;

/**
 * Author: SherlockShi
 * Date:   2016-10-30 22:18
 * Description:
 */

public class Constants {

    public static class ErrorNo {
        public static final int Success                 = 0;        // 成功
        public static final int ServerError             = 10001;    // 服务器异常
        public static final int ServerReturnErrorMsg    = 10002;    // 服务器返回错误信息
    }

    // 工程相关常量
    public static class Project {
        public static final String ProjectName = "AccountBookApp";
    }

    // SharedPreferences相关常量
    public static class SharedPreferences {
        public static final String SharedPreferencesName = Project.ProjectName
                + ".sp";
        public static final String XxxKey = "key";
    }

    public static class GreenDAO{
        //数据库名字
        public static final String databaseName="notes-db";
        //加密的数据库名字
        public static final String databaseNameEncryted="notes-db-encryted";
        //加密的数据库的密码
        public static final String passWord="francis";
    }

    public static class Bomb{
        public static final String applicationId="5c837933af26f366b63cdf30cc27aeb6";
    }
}
