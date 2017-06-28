package com.fruitgrower.fruitgrower.presenter.bmob;

import android.widget.Toast;

import com.fruitgrower.fruitgrower.FruitApplication;
import com.fruitgrower.fruitgrower.model.bmob.UserLogin;
import com.fruitgrower.fruitgrower.view.utils.SharePreferenceUtils;
import com.fruitgrower.fruitgrower.view.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by lgq on 2017/6/27.
 */

public class UserLoginPresenter implements IUserLoginPresenter{



    @Override
    public void register(final String username, final String password) {
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(username);
        userLogin.setEmail(username);
        userLogin.setPassword(password);
        userLogin.signUp(new SaveListener<Object>() {
            @Override
            public void done(Object s, BmobException e) {
                if(e == null){
                    SharePreferenceUtils.setLoginUserName(FruitApplication.getContext(), username);
                    SharePreferenceUtils.setLoginPassWord(FruitApplication.getContext(), password);
                    ToastUtils.showToast(FruitApplication.getContext(), "注册成功:", Toast.LENGTH_SHORT);
                }else{
                    Logger.i("注册失败");
                }
            }
        });
    }

    @Override
    public void loginUser() {

    }
}
