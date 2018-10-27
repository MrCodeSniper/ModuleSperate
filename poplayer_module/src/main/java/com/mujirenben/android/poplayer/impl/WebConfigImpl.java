package com.mujirenben.android.poplayer.impl;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;


import com.mujirenben.android.poplayer.interfaces.PopWebViewListener;
import com.mujirenben.android.poplayer.interfaces.WebViewConfig;

import com.mujirenben.android.poplayer.webview.*;
import java.lang.reflect.Method;


/**
 * Created by mac on 2018/7/11.
 */

public  class WebConfigImpl implements WebViewConfig {

    public final String TAG=this.getClass().getSimpleName();

    private PopWebViewListener popWebViewListener;

    public void setPopWebViewListener(PopWebViewListener popWebViewListener) {
        this.popWebViewListener = popWebViewListener;
    }

    ///////////////////////////////////////配置WEBVIEW 待后续继续优化 参考网易考拉团队webview优化////////////////////////////////

    @Override
    public void setUpWebConfig(WebView webView,String showScheme) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(
                    WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }

        initFilePermission(webView,true);

        PopWebViewChromeClient popWebViewChromeClient=new PopWebViewChromeClient();
        PopWebViewClient  popWebViewClient=new PopWebViewClient();
        popWebViewClient.setListener(popWebViewListener);
        popWebViewChromeClient.setListener(popWebViewListener);
        webView.setWebChromeClient(popWebViewChromeClient);
        webView.setWebViewClient(popWebViewClient);

        WebSettings settings = webView.getSettings();
        initSetting(settings);
        webView.setBackgroundColor(0);
        webView.getBackground().setAlpha(0);

        webView.loadUrl(showScheme);

        //移除部分系统JavaScript接口 涉及安全问题
        PopWebViewSecurity.removeJavascriptInterfaces(webView);

        if(popWebViewListener!=null){
            popWebViewListener.addUpJavaNativeJSInterface(webView);
        }
    }



    private void initSetting(WebSettings settings){
        //允许js代码
        //在Android 4.3版本调用WebSettings.setJavaScriptEnabled()方法时会调用一下reload方法，同时会回调多次WebChromeClient.onJsPrompt()
        settings.setJavaScriptEnabled(true);
        //允许SessionStorage/LocalStorage存储
        settings.setDomStorageEnabled(true);
        //禁用放缩
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        //禁用文字缩放
        settings.setTextZoom(100);
        //10M缓存，api 18后，系统自动管理。
        settings.setAppCacheMaxSize(10 * 1024 * 1024);
        //允许缓存，设置缓存位置
        settings.setAppCacheEnabled(true);
//        settings.setAppCachePath(context.getDir("appcache", 0).getPath());
        //允许WebView使用File协议
        settings.setAllowFileAccess(true);
        //不保存密码
        settings.setSavePassword(false);
        //自动加载图片
        settings.setLoadsImagesAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
    }


    @Override
    public String toString() {
        return "WebConfig State";
    }


    /**
     *   设置是否允许通过 file url 加载的 Javascript 可以访问其他的源(包括http、https等源)
     * @param webView
     */
    private void initFilePermission(WebView webView,boolean isFileGranted){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            webView.getSettings().setAllowUniversalAccessFromFileURLs(isFileGranted);
        }else{
            try {
                Class<?> clazz = webView.getSettings().getClass();
                Method method = clazz.getMethod("setAllowUniversalAccessFromFileURLs", boolean.class);
                if (method != null) {
                    method.invoke(webView.getSettings(), isFileGranted);
                }
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }



}
