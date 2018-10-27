package com.mujirenben.android.poplayer.interfaces;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/27.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.view.View;
import android.webkit.WebView;

public interface PopWebViewListener {


    void showLoading();
    void hideLoading();

    void showFullScreenView(View view);
    void hideFullScreenView();


    void injectJsBridge(WebView webView);

    void invokeAppServices(String instruction) ;

    void addUpJavaNativeJSInterface(WebView webView);

}
