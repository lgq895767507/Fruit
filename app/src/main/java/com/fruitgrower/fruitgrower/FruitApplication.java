package com.fruitgrower.fruitgrower;

import android.app.Application;
import android.content.Context;

import com.fruitgrower.fruitgrower.view.utils.ConstantStringUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import cn.bmob.v3.Bmob;

/**
 * Created by lgq on 2017/6/27.
 */

/**
 * as application class, for init application start work,
 * and support whole object this.
 */
public class FruitApplication extends Application{

    private static FruitApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        mContext = this;
        Bmob.initialize(this, ConstantStringUtils.APP_KEY, "fruit");
        //initialize logger
        Logger.addLogAdapter(new AndroidLogAdapter(){
            @Override
            public boolean isLoggable(int priority, String tag) {
                //签名打包后的日志便不显示
                return BuildConfig.DEBUG;
            }
        });
    }

    public static Context getContext(){
        return mContext;
    }
}
