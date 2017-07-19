package com.fruitgrower.fruitgrower.view.holder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.fruitgrower.fruitgrower.R;

/**
 * Created by lgq on 2017/7/17.
 */

public class MainDataHolder extends ViewHolder {

    public TextView dataItemText;
    public TextView messageDate;

    public MainDataHolder(View itemView) {
        super(itemView);
        dataItemText = itemView.findViewById(R.id.dataItemText);
        messageDate = itemView.findViewById(R.id.messageDate);
    }
}
