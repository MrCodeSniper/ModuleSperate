package com.mujirenben.android.poplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.mujirenben.android.poplayer.impl.PushManagerImpl;
import com.mujirenben.android.poplayer.impl.TimerManagerImpl;
import com.mujirenben.android.poplayer.impl.WebConfigImpl;
import com.mujirenben.android.poplayer.interfaces.LayerLifecycle;
import com.mujirenben.android.poplayer.interfaces.WebViewConfig;
import com.mujirenben.android.poplayer.proxy.LayerLifeCycleProxy;
import com.mujirenben.android.poplayer.strategy.DialogLayerStrategyImpl;
import com.mujirenben.android.poplayer.strategy.ILayerStrategy;
import com.mujirenben.android.poplayer.strategy.LayerStrategyChooser;
import com.mujirenben.android.poplayer.strategy.WebViewLayerStrategyImpl;
import com.mujirenben.android.poplayer.interfaces.PopWebViewListener;


/**
 * Created by mac on 2018/7/10.
 */

public class HrzLayerView extends View {

    public final String TAG=getClass().getSimpleName();

    private PopWebViewListener listener;

    public void setListener(PopWebViewListener listener) {
        this.listener = listener;
    }

    private boolean isShow=false;

    public static int STATE_WEBVIEW=1;
    public static int STATE_DIALOG=0;
    public int state=-1;

    private ILayerStrategy iLayerStrategy;

    private Context mContext;

    private LayerLifecycle proxy;

    public HrzLayerView(Context context, int state) {
        super(context);
        mContext=context;
        this.state=state;
    }

    public HrzLayerView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
    }

    public HrzLayerView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
    }


    public void initLayerView(WebViewConfig webViewConfig) {


        WebConfigImpl webConfig=new WebConfigImpl();
        webConfig.setPopWebViewListener(listener);

        HrzLayerController hrzLayer= HrzLayerController.builder()
                .setPushManagerImpl(new PushManagerImpl())
                .setTimerManagerImpl(new TimerManagerImpl())
                .setWebViewConfigImpl(webConfig)
                .build();


        if(state==STATE_DIALOG){
            if(dialogView!=null){
                iLayerStrategy=new DialogLayerStrategyImpl(dialogView,R.style.Dialog_Fullscreen);
            }
        }else if(state==STATE_WEBVIEW){
            iLayerStrategy=new WebViewLayerStrategyImpl(webViewConfig,loadScheme);
        }else {
            iLayerStrategy=null;
            return;
        }

        hrzLayer.setLayerStrategyChooser(new LayerStrategyChooser(iLayerStrategy,mContext));
        proxy= (LayerLifecycle) new LayerLifeCycleProxy(hrzLayer).getProxyInstance();
        proxy.onCreate();
    }


    ///////////////////////////// HrzLayerView的显示状态 /////////////////////////////////////////

    public void show(){
        proxy.onShow();
        isShow=true;
    }

    public void dismiss(){
        proxy.onDismiss();
        isShow=false;
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        proxy.onRecycle();
    }

    /**
     * 设置弹窗是否可以取消，这里只针对 STATE_DIALOG 状态
     * @param flag
     */
    public void setLayerCanCancel(boolean flag){
        if(iLayerStrategy != null){
            iLayerStrategy.setLayerCanCancel(flag);
        }
    }


    public boolean isShow() {
        return isShow;
    }


    ///////////////////////////// 用户设置DialogView /////////////////////////////////////////

    private  View dialogView;

    public void setDialogView(View dialogView) {
        this.dialogView = dialogView;
    }

    public View getDialogView() {
        return dialogView;
    }

    private String loadScheme="";

    public void setLoadScheme(String loadScheme) {
        this.loadScheme = loadScheme;
    }




}
