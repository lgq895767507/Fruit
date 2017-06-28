package com.fruitgrower.fruitgrower.view.utils;

import android.content.Context;

/**
 * Created by lgq on 2017/6/28.
 */

public class SharePreferenceUtils {

    /**
     * rember login username and password
     */
    private static String LOGIN_USER_NAME = "login_user_name";
    private static String LOGIN_PASS_WORD = "login_pass_word";
    public static void setLoginUserName(Context context, String userName){
        context.getSharedPreferences(LOGIN_USER_NAME, Context.MODE_PRIVATE)
                .edit()
                .putString("userName", userName)
                .apply();
    }

    public static String getLoginUserName(Context context){
        return context.getSharedPreferences(LOGIN_USER_NAME, Context.MODE_PRIVATE)
                .getString("userName","");
    }

    public static void setLoginPassWord(Context context, String password){
        context.getSharedPreferences(LOGIN_PASS_WORD, Context.MODE_PRIVATE)
                .edit()
                .putString("password", password)
                .apply();
    }

    public static String getLoginPassword(Context context){
        return context.getSharedPreferences(LOGIN_PASS_WORD, Context.MODE_PRIVATE)
                .getString("password","");
    }

}
