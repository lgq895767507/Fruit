package com.fruitgrower.fruitgrower.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;

import com.fruitgrower.fruitgrower.R;
import com.fruitgrower.fruitgrower.view.utils.SharePreferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by lgq on 2017/6/27.
 */

public class SplashActivity extends BaseActivity {

    private final String TAG = this.getClass().getSimpleName();

    private static final int WHAT_INTENT2LOGIN = 1;
    private static final int WHAT_INTENT2MAIN = 2;
    private static final long SPLASH_DUR_TIME = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get rid of status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_flash);
        if (!TextUtils.isEmpty(SharePreferenceUtils.getLoginUserName(this)) && !TextUtils.isEmpty(SharePreferenceUtils.getLoginPassword(this))){
            //作为判断是否已经登录过，若登陆过则不需再次注册
            new FlashHandler(this).sendEmptyMessageDelayed(WHAT_INTENT2MAIN, SPLASH_DUR_TIME);
        }else {
            new FlashHandler(this).sendEmptyMessageDelayed(WHAT_INTENT2LOGIN, SPLASH_DUR_TIME);
        }
    }

    private class FlashHandler extends Handler {
        WeakReference<Activity> weakReference;

        FlashHandler(SplashActivity activity) {
            weakReference = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Activity activity = weakReference.get();
            if (activity != null) {
                switch (msg.what) {
                    case WHAT_INTENT2LOGIN:
                        intent2Activity(LoginActivity.class);
                        finish();
                        break;
                    case WHAT_INTENT2MAIN:
                        intent2Activity(MainActivity.class);
                        finish();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
