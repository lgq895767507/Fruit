package com.fruitgrower.fruitgrower.presenter.bmob;

/**
 * Created by lgq on 2017/7/18.
 */

public interface IMessagePresenter {

    void saveMessage(String content);

    void findMessageAll(MessagePresenter.MessageListCallBack callBack);

    void findMessageAll(MessagePresenter.MessageListCallBack callBack, int skip);
}
