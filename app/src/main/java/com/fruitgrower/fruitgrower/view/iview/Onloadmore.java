package com.fruitgrower.fruitgrower.view.iview;

import android.widget.Toast;

import com.fruitgrower.fruitgrower.FruitApplication;
import com.fruitgrower.fruitgrower.model.bmob.Message;
import com.fruitgrower.fruitgrower.presenter.bmob.IMessagePresenter;
import com.fruitgrower.fruitgrower.presenter.bmob.MessagePresenter;
import com.fruitgrower.fruitgrower.view.adapter.MainDataAdapter;
import com.fruitgrower.fruitgrower.view.utils.ConstantUtils;
import com.fruitgrower.fruitgrower.view.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgq on 2017/7/18.
 */

public class Onloadmore implements OnLoadmoreListener {

    private MainDataAdapter mainDataAdapter;
    private ArrayList<Message> datas;
    private int skip = 10;

    public Onloadmore(MainDataAdapter mainDataAdapter, ArrayList<Message> datas) {
        this.mainDataAdapter = mainDataAdapter;
        this.datas = datas;
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        refreshlayout.finishLoadmore(2000);
        Logger.i("load more.");
        IMessagePresenter messagePresenter = new MessagePresenter();
        messagePresenter.findMessageAll(new MessagePresenter.MessageListCallBack() {
            @Override
            public void success(List<Message> list) {
                //加载更多，临时保存上次的数据
                if (list.size() == 0) {
                    //没有任何数据
                    ToastUtils.showToast(FruitApplication.getContext(), "没有更多数据", Toast.LENGTH_SHORT);
                } else if (list.size() < ConstantUtils.LIMIT_COUNT) {
                    //说明当前页面是最后一页
                    if (datas.size() < skip + list.size()) {
                        datas.addAll(list);
                        mainDataAdapter.notifyDataSetChanged();
                    } else if (datas.size() == skip + list.size()) {
                        ToastUtils.showToast(FruitApplication.getContext(), "没有更多数据", Toast.LENGTH_SHORT);
                    }
                } else {
                    //说明还会有下一页
                    skip = skip + skip;
                    datas.addAll(list);
                    mainDataAdapter.notifyDataSetChanged();
                    ToastUtils.showToast(FruitApplication.getContext(), "加载更多", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void failed() {
                ToastUtils.showToast(FruitApplication.getContext(), "没有更多", Toast.LENGTH_SHORT);
            }
        }, skip);
    }
}
