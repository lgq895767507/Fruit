package com.fruitgrower.fruitgrower.view.utils;

import android.view.View;

/**
 * Created by lgq on 2017/7/13.
 */

public interface IimageLoader {

    void showImage(View view, String url, ImageLoaderOptions options);

    void showImage(View view, int drawable, ImageLoaderOptions options);

    class ImageLoaderOptions{

    }
}
