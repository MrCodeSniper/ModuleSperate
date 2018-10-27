package com.stream.chenhong.moduleastandalone;
//Thanks For Your Reviewing My Code
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/27.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;

import com.mujirenben.android.poplayer.HrzLayerView;
import com.mujirenben.android.poplayer.config.LayerConfig;
import com.mujirenben.android.poplayer.impl.WebConfigImpl;


import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import com.mujirenben.android.poplayer.interfaces.PopWebViewListener;
import com.mujirenben.android.poplayer.webview.*;
import static com.mujirenben.android.poplayer.HrzLayerView.STATE_WEBVIEW;

public class PopLayerActivity extends Activity implements PopWebViewListener {

    private HrzLayerView hrzLayerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poplayer);
        findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRedPocketView();
            }
        });

    }

    private void showRedPocketView() {
        if (hrzLayerView == null) {
            hrzLayerView = new HrzLayerView(this, STATE_WEBVIEW);
            hrzLayerView.setLoadScheme(LayerConfig.redPocketScheme);
            WebConfigImpl webConfig=new WebConfigImpl();
            webConfig.setPopWebViewListener(this);
            hrzLayerView.initLayerView(webConfig);
        }
        hrzLayerView.show();
    }

    private void hideLayerView() {
        if (hrzLayerView != null) {
            hrzLayerView.dismiss();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showFullScreenView(View view) {

    }

    @Override
    public void hideFullScreenView() {

    }

    @Override
    public void injectJsBridge(WebView webView) {
        webView.loadUrl("javascript:" + InjectUtils.getJsCode(this));
    }

    @Override
    public void invokeAppServices(String instruction)  {
        try{
            PopWebViewService popWebViewService=null;

            JSONObject jsonObject = new JSONObject(instruction.substring(instruction.indexOf("{"), instruction.lastIndexOf("}") + 1));

            String invokeId=jsonObject.getString("invokeId");
            String methodName = jsonObject.getString("methodName");
            String android_methodName = methodName.split(Pattern.quote("."))[1];
            JSONObject paramObject = jsonObject.getJSONObject("methodParams");

            Iterator iterator = paramObject.keys();
            Map map = new HashMap();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                map.put(key, paramObject.getString(key));
            }

//        map.put("context", BrowserActivity.this);
//        map.put("webview",webView);
            map.put("invokeId",invokeId);


            //前端调原生 方法集合类
            Class<PopWebViewService> invokeMethodObject = (Class<PopWebViewService>) Class.forName(PopWebViewService.class.getResource("").toString());
            if (invokeMethodObject != null) {
                popWebViewService = invokeMethodObject.newInstance();
            }

            if (invokeMethodObject != null) {
                Method repay1 = invokeMethodObject.getDeclaredMethod(android_methodName, Map.class);
                if (repay1 != null&& popWebViewService!=null) {
                    repay1.setAccessible(true);
                    repay1.invoke(popWebViewService, map);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addUpJavaNativeJSInterface(WebView webView) {
        webView.addJavascriptInterface(new PopWebViewJsInterface(webView),"poplayer");
    }
}
