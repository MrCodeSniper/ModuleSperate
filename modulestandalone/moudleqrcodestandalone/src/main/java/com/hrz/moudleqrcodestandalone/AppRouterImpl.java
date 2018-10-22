package com.hrz.moudleqrcodestandalone;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/22.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;
import android.content.Intent;
import android.database.Observable;
import android.util.Log;

import com.stream.chenhong.callback.Callback;
import com.stream.chenhong.router.AppRouter;

import io.github.prototypez.appjoint.core.ServiceProvider;

@ServiceProvider
public class AppRouterImpl implements AppRouter {
    @Override
    public String syncMethodOfApp() {
        return "syncMethodResult";
    }

    @Override
    public Observable<String> asyncMethod1OfApp() {
        return null;
    }

    @Override
    public void asyncMethod2OfApp(final Callback<String> callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(callback!=null){
                    callback.onResult("asyncMethod2Result");
                }else {
                    Log.e(this.getClass().getSimpleName(),"xxxfff");
                }

            }
        }).start();

    }

    @Override
    public void startQrCodeActivity(Context context){
        context.startActivity(new Intent(context,QrcodeTestActivity.class));
    }

}
