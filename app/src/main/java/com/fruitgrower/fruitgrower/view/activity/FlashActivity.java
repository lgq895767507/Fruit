package com.fruitgrower.fruitgrower.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.fruitgrower.fruitgrower.R;

import java.lang.ref.WeakReference;

/**
 * Created by lgq on 2017/6/27.
 */

public class FlashActivity extends BaseActivity {

    private static final int WHAT_INTENT2LOGIN = 1;
    private static final int WHAT_INTENT2MAIN = 2;
    private static final long SPLASH_DUR_TIME = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get rid of status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_flash);
        new FlashHandler(this).sendEmptyMessageDelayed(WHAT_INTENT2LOGIN, SPLASH_DUR_TIME);
    }

    private class FlashHandler extends Handler {
        WeakReference<Activity> weakReference;

        FlashHandler(FlashActivity activity) {
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
