package com.fruitgrower.fruitgrower.presenter.bmob;

import android.widget.Toast;

import com.fruitgrower.fruitgrower.FruitApplication;
import com.fruitgrower.fruitgrower.model.bmob.Message;
import com.fruitgrower.fruitgrower.view.utils.ConstantUtils;
import com.fruitgrower.fruitgrower.view.utils.ToastUtils;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by lgq on 2017/7/18.
 */

/**
 * 网络请求都是异步独立线程的
 */
public class MessagePresenter implements IMessagePresenter {

    @Override
    public void saveMessage(String content) {
        Message message = new Message();
        message.setContent(content);
        message.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    ToastUtils.showToast(FruitApplication.getContext(), "发送成功", Toast.LENGTH_SHORT);
                } else {
                    ToastUtils.showToast(FruitApplication.getContext(), "发送失败" + e.getMessage(), Toast.LENGTH_SHORT);
                }
            }
        });
    }

    @Override
    public void findMessageAll(final MessageListCallBack callBack) {
        BmobQuery<Message> query = new BmobQuery<>();
        query.setLimit(ConstantUtils.LIMIT_COUNT).order("-createdAt")
                .findObjects(new FindListener<Message>() {
                    @Override
                    public void done(List<Message> list, BmobException e) {
                        if (e == null) {
                            callBack.success(list);
                        } else {
                            callBack.failed();
                        }
                    }
                });
    }

    @Override
    public void findMessageAll(final MessageListCallBack callBack, int skip) {
        BmobQuery<Message> query = new BmobQuery<>();
        query.setLimit(ConstantUtils.LIMIT_COUNT).setSkip(skip).order("-createdAt")
                .findObjects(new FindListener<Message>() {
                    @Override
                    public void done(List<Message> list, BmobException e) {
                        if (e == null) {
                            callBack.success(list);
                        } else {
                            callBack.failed();
                        }
                    }
                });
    }

    public interface MessageListCallBack {
        void success(List<Message> list);

        void failed();
    }
}
