package com.stream.chenhong.modulea;

import android.app.Application;
import android.util.Log;

/**
 * Created by Administrator on 2018\10\22 0022.
 */

public class ModuleaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(this.getClass().getSimpleName(),"业务组件初始化");
    }
}
