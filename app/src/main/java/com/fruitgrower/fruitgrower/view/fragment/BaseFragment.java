package com.fruitgrower.fruitgrower.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.fruitgrower.fruitgrower.view.activity.MainActivity;

/**
 * Created by lgq on 2017/7/17.
 */

public class BaseFragment extends Fragment {

    protected MainActivity activity;

    public BaseFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
    }
}
