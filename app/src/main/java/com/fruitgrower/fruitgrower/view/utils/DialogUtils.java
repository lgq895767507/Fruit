package com.fruitgrower.fruitgrower.view.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by lgq on 2017/7/18.
 */

public class DialogUtils {

    private Context mContext;
    private AlertDialog.Builder alertDialog ;

    public DialogUtils(Context context){
        mContext = context;
    }

    public AlertDialog.Builder createDialog(String title,  String confirmTitle, final CallBack1 callback){
        alertDialog = new AlertDialog.Builder(mContext);
        alertDialog.setTitle(title);
        alertDialog.setPositiveButton(confirmTitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.confirm(dialogInterface);
            }
        });

        return alertDialog;
    }

    public AlertDialog.Builder createDialog(String title, String cancelTitle, String confirmTitle, final CallBack2 callback){
        alertDialog = new AlertDialog.Builder(mContext);
        alertDialog.setTitle(title);
        alertDialog.setPositiveButton(confirmTitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.confirm(dialogInterface);
            }
        });
        alertDialog.setNegativeButton(cancelTitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.cancel(dialogInterface);
            }
        });
        return alertDialog;
    }

    public interface CallBack1{
        void confirm(DialogInterface dialogInterface);
    }

    public interface CallBack2{
        void cancel(DialogInterface dialogInterface);
        void confirm(DialogInterface dialogInterface);
    }

}
