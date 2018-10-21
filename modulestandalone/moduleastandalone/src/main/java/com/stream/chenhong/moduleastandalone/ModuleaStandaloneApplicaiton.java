package com.stream.chenhong.moduleastandalone;

import android.util.Log;

import com.stream.chenhong.modulea.ModuleaApplication;

/**
 * Created by Administrator on 2018\10\22 0022.
 */

public class ModuleaStandaloneApplicaiton extends ModuleaApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(this.getClass().getSimpleName(),"技术组件初始化");
    }

}
