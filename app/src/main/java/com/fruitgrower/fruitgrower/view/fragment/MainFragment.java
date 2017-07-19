package com.fruitgrower.fruitgrower.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fruitgrower.fruitgrower.R;
import com.fruitgrower.fruitgrower.model.bmob.Message;
import com.fruitgrower.fruitgrower.presenter.bmob.IMessagePresenter;
import com.fruitgrower.fruitgrower.presenter.bmob.MessagePresenter;
import com.fruitgrower.fruitgrower.view.adapter.MainDataAdapter;
import com.fruitgrower.fruitgrower.view.iview.OnRefresh;
import com.fruitgrower.fruitgrower.view.iview.Onloadmore;
import com.fruitgrower.fruitgrower.view.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgq on 2017/7/17.
 */

public class MainFragment extends BaseFragment{


    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    private MainDataAdapter mainDataAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.main_fragment, null);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*
        Called immediately after onCreateView(LayoutInflater, ViewGroup, Bundle) has returned,
        but before any saved state has been restored in to the view.
         This gives subclasses a chance to initialize themselves once they know their view hierarchy has been completely created.
         The fragment's view hierarchy is not however attached to its parent at this point.

         */
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycleView);
        refreshLayout = view.findViewById(R.id.refreshLayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
    }

    private void initData(){
        final ArrayList<Message> datas = new ArrayList<>();
        //data request
        IMessagePresenter messagePresenter = new MessagePresenter();
        messagePresenter.findMessageAll(new MessagePresenter.MessageListCallBack() {

            @Override
            public void success(List<Message> list) {
                datas.addAll(list);
                Logger.i("accept:");
                mainDataAdapter = new MainDataAdapter(datas, activity);
                recyclerView.setAdapter(mainDataAdapter);
                refreshLayout.setOnRefreshListener(new OnRefresh(mainDataAdapter, datas));
                refreshLayout.setOnLoadmoreListener(new Onloadmore(mainDataAdapter, datas));
            }

            @Override
            public void failed() {
                ToastUtils.showToast(getContext(), "没有数据", Toast.LENGTH_SHORT);
            }
        });
    }
}
