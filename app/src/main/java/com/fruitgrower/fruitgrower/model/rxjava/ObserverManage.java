package com.fruitgrower.fruitgrower.model.rxjava;


import com.fruitgrower.fruitgrower.model.bmob.Message;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by lgq on 2017/7/18.
 */

public class ObserverManage {


    public static Consumer messageList(){

        return new Consumer<List<Message>>() {

            @Override
            public void accept(List<Message> messages) throws Exception {

            }
        };
    }
}
