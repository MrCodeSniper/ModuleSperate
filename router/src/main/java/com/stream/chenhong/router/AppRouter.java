package com.stream.chenhong.router;

import android.content.Context;
import android.database.Observable;

import com.stream.chenhong.callback.Callback;

/**
 * 所有业务模块希望暴露给其它模块调用的方法
 * Created by Administrator on 2018\10\22 0022.
 */

public interface  AppRouter {

    /**
     * 普通的同步方法调用
     */
    String syncMethodOfApp();

    /**
     * 以 RxJava 形式封装的异步方法
     */
    Observable<String> asyncMethod1OfApp();

    /**
     * 以 Callback 形式封装的异步方法
     */
    void asyncMethod2OfApp(Callback<String> callback);

    void  startQrCodeActivity(Context context);
}
