package com.mujirenben.android.poplayer.strategy;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/7/6.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.app.Dialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;

public class DialogLayerStrategyImpl implements ILayerStrategy{

    private View contentView;
    private Dialog dialog;
    private boolean layerCanCancel = true;
    private int themeType;


    /** 原生dialog需要传dialog的布局 **/
    public DialogLayerStrategyImpl(View  view, int themeResId) {
        this.contentView = view;
        this.themeType=themeResId;
    }

    @Override
    public void showLayer(Context context) {
        if(dialog==null){
            dialog=new Dialog(new ContextThemeWrapper(context,themeType));
        }
        dialog.setCancelable(layerCanCancel);
        dialog.setContentView(contentView);
        dialog.setCancelable(true);
        dialog.show();
    }

    @Override
    public void dismissLayer(Context context) {
        if(dialog!=null){
            dialog.cancel();
        }
    }

    @Override
    public void destroyLayer(Context context) {
        if(dialog!=null){
            dialog.cancel();
        }
    }

    @Override
    public void setLayerCanCancel(boolean flag) {
      layerCanCancel = flag;
    }
}
