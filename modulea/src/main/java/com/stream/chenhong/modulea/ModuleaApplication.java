package com.stream.chenhong.modulea;

import android.app.Application;
import android.util.Log;

import io.github.prototypez.appjoint.core.ModuleSpec;

/**
 * Created by Administrator on 2018\10\22 0022.
 */
@ModuleSpec
public class ModuleaApplication extends Application {

    public static Application INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = (Application)getApplicationContext();
        Log.e(this.getClass().getSimpleName(),"业务组件初始化");
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
