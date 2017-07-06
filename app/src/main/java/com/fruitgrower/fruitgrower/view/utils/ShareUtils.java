package com.fruitgrower.fruitgrower.view.utils;

import android.content.Context;
import android.content.Intent;

import com.fruitgrower.fruitgrower.R;

/**
 * Created by lgq on 2017/7/6.
 */

public class ShareUtils {

    private ShareUtils(){}

    public static void shareLink(Context context, String text) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, text);
        context.startActivity(Intent.createChooser(i, context.getString(R.string.share_url_label)));
    }
}
