package com.hrz.moudleqrcodestandalone;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/22.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.util.Log;

import com.google.zxing.application.QrcodeModuleApplication;

import io.github.prototypez.appjoint.core.AppSpec;

//import io.github.prototypez.appjoint.core.AppSpec;

@AppSpec
public class QrCodeTestApplication extends QrcodeModuleApplication {


    public static QrCodeTestApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        Log.e(this.getClass().getSimpleName(),"技术组件初始化");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.e(getClass().getSimpleName(),"onLowMemory");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.e(getClass().getSimpleName(),"onTerminate");
    }


}
