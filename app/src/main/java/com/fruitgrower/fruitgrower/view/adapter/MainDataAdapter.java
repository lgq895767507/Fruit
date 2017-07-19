package com.fruitgrower.fruitgrower.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fruitgrower.fruitgrower.R;
import com.fruitgrower.fruitgrower.model.bmob.Message;
import com.fruitgrower.fruitgrower.view.holder.MainDataHolder;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

/**
 * Created by lgq on 2017/7/17.
 */

public class MainDataAdapter extends RecyclerView.Adapter<MainDataHolder>{

    private ArrayList<Message> datas;
    private Context mContext;

    public MainDataAdapter(ArrayList<Message> data, Context context){
        datas = data;
        mContext = context;
    }

    @Override
    public MainDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_data_item, parent, false);
        return  new MainDataHolder(view);
    }

    @Override
    public void onBindViewHolder(MainDataHolder holder, int position) {
        holder.dataItemText.setText(datas.get(position).getContent());
        holder.messageDate.setText(datas.get(position).getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
