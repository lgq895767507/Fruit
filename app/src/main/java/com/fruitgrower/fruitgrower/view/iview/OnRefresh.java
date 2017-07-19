package com.fruitgrower.fruitgrower.view.iview;

import android.widget.Toast;

import com.fruitgrower.fruitgrower.FruitApplication;
import com.fruitgrower.fruitgrower.model.bmob.Message;
import com.fruitgrower.fruitgrower.presenter.bmob.IMessagePresenter;
import com.fruitgrower.fruitgrower.presenter.bmob.MessagePresenter;
import com.fruitgrower.fruitgrower.view.adapter.MainDataAdapter;
import com.fruitgrower.fruitgrower.view.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgq on 2017/7/18.
 */

public class OnRefresh implements OnRefreshListener {

    private MainDataAdapter mainDataAdapter;
    private ArrayList<Message> datas;

    public OnRefresh(MainDataAdapter mainDataAdapter,ArrayList<Message> datas) {
        this.mainDataAdapter = mainDataAdapter;
        this.datas = datas;
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        refreshlayout.finishRefresh(2000);
        Logger.i("refresh");
        IMessagePresenter messagePresenter = new MessagePresenter();
        messagePresenter.findMessageAll(new MessagePresenter.MessageListCallBack() {
            @Override
            public void success(List<Message> list) {
                datas.clear();
                datas.addAll(list);
                mainDataAdapter.notifyDataSetChanged();
                ToastUtils.showToast(FruitApplication.getContext(), "更新成功!", Toast.LENGTH_SHORT);
            }

            @Override
            public void failed() {

            }
        });


    }
}
