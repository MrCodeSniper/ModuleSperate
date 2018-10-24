package com.hrz.xsh.utils;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/24.Best Wishes to You!  []~(~▽~)~* Cheers!


import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {


    private static RetrofitUtil retrofitUtils = null;

    private final Retrofit retrofit;

    public static RetrofitUtil getRetrofitUtils() {
        if (retrofitUtils == null) {
            retrofitUtils = new RetrofitUtil();
        }
        return retrofitUtils;
    }


    public RetrofitUtil() {
        retrofit = new Retrofit.Builder()//建造者模式，
                .baseUrl("https://xdz.hdyl.net.cn")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//和RxJava集合使用的时候需要配置的
                .addConverterFactory(GsonConverterFactory.create(new Gson()))//直接将json---JavaBean
                .build();
    }


    //通过反射创建服务的实例对象
    //T  代表泛型里面的type
    //why  通过反射生成接口的子类对象，方便调用方法
    public <T> T createRequest(Class<T> clz) {
        T t = retrofit.create(clz);
        return t;
    }


}
