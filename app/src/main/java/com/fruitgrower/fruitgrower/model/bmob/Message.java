package com.fruitgrower.fruitgrower.model.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by lgq on 2017/7/18.
 */

public class Message extends BmobObject {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
