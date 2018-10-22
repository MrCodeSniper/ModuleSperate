package com.stream.chenhong.modulea;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.stream.chenhong.callback.Callback;

/**
 * Created by Administrator on 2018\10\21 0021.
 */

public class ModuleaActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_a_activity);

        // 获得同步调用的结果
        String syncResult = RouterServices.sAppRouter.syncMethodOfApp();
        Log.e(getClass().getSimpleName(),"同步结果:"+syncResult);
        // 发起异步调用
        RouterServices.sAppRouter.asyncMethod2OfApp(new Callback<String>() {
            @Override
            public void onResult(String data) {
                // handle asyncResult
                Log.e("xxx","yyy");
                Log.e(getClass().getSimpleName(),"异步回调结果:"+data);
            }
        });








    }


    public void route(View view){
        RouterServices.sAppRouter.startQrCodeActivity(this);
    }

}
