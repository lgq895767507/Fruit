package com.fruitgrower.fruitgrower.view.utils;

import android.view.View;

/**
 * Created by lgq on 2017/7/13.
 */

/**
 * 封装一层图片处理：其他的框架glide,fresco,picasso实现IimageLoader接口
 * 目的是：避免修改框架动用全部模块，图片管理在自己的掌控下
 */

public class ImageLoaderStrategyUtils implements IimageLoader {

    //单例
    private static  final ImageLoaderStrategyUtils INSTANCE = new ImageLoaderStrategyUtils();
    private ImageLoaderStrategyUtils imageLoader;

    public static ImageLoaderStrategyUtils getInstance(){
        return INSTANCE;
    }

    private ImageLoaderStrategyUtils(){
        imageLoader = new ImageLoaderStrategyUtils();
    }


    @Override
    public void showImage(View view, String url, ImageLoaderOptions options) {
        //其他的图片框架实现
    }

    @Override
    public void showImage(View view, int drawable, ImageLoaderOptions options) {

    }
}
