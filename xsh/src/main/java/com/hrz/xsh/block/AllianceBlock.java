package com.hrz.xsh.block;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/19.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hrz.xsh.R;
import com.hrz.xsh.adapter.XshShopAdapter;
import com.hrz.xsh.controller.AlliaceController;
import com.hrz.xsh.entity.AllianceHomeShopsEntity;
import com.hrz.xsh.receiver.ICaptureReceiver;
import com.hrz.xsh.view.SpaceItemDecoration;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

import static com.hrz.xsh.consts.XshConstant.CAPTURE_RESULT;
import static com.hrz.xsh.consts.XshConstant.XSH_ACTION;

/**
 *  block用来通信 生命周期的观察者
 */
public class AllianceBlock extends FrameLayout implements LifecycleObserver {

    public static final String TAG=AllianceBlock.class.getSimpleName();

    private AlliaceController alliaceController;

    private EditTypeFactory editTypeFactory;

    private WeakReference<ICaptureReceiver> receiver;
    private Context mContext;
    private XshShopAdapter xshShopAdapter;


    public AllianceBlock(Context context,  ICaptureReceiver iCaptureReceiver,EditTypeFactory editTypeFactory) {
        super(context);
        this.mContext=context;
        this.receiver=new WeakReference<ICaptureReceiver>(iCaptureReceiver);
        this.editTypeFactory=editTypeFactory;
        init();
    }

    private void init() {
        alliaceController=new AlliaceController(mContext,this,editTypeFactory);
        ((LifecycleRegistryOwner)mContext).getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        View view= LayoutInflater.from(getContext()).inflate(R.layout.xsh_alliance_page_xml,null);
        addView(view,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        initEventPoster();
        initPreView();
        Log.e(TAG,"oncreate启动 准备loaddata");

        alliaceController.load(getRequestMap());
    }



    public Map<String,String> getRequestMap(){
        Map<String,String> map=new HashMap();
        //"4.0.0",1,10,"北京市",116.33,39.89
        map.put("v","4.0.0");
        map.put("page","1");
        map.put("pageSize","10");
        map.put("city","北京市");
        map.put("longitude","39.89");
        map.put("latitude","116.33");
        return map;
    }



    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestory(){
        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(receiver.get());
        receiver.clear();
    }


    //view层操作view的方法。controller使用
    public void bindData(AllianceHomeShopsEntity bean) {
        Log.e(TAG,bean.toString());
        xshShopAdapter.setNewData(bean.getData().getAccordList());
    }

    private void initEventPoster() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(XSH_ACTION);
        //注册本地接收器
        LocalBroadcastManager.getInstance(mContext).registerReceiver(receiver.get(),intentFilter);
    }



    private void initPreView() {
        RecyclerView xshRvShop=findViewById(R.id.xsh_rv_shop);
        xshRvShop.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        xshRvShop.setFocusable(false);
        xshRvShop.addItemDecoration(new SpaceItemDecoration(0));
        xshShopAdapter=new XshShopAdapter(R.layout.recycleview_item_home_shop);
        xshRvShop.setAdapter(xshShopAdapter);
    }





    /**
     *   发送本地广播
     * @param result
     */
    private void sendLocalBrodCast(String result){
        Intent intent = new Intent(XSH_ACTION);
        intent.putExtra(CAPTURE_RESULT,result);
        LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
    }




    public  interface EditTypeFactory{
        //Get方法
        Observable getSubmitObservable(Context context, Map<String, String> options);

        void updateAndSync(Context context, Object o);

        String getOldContent(Context context);
    }


    public static class Builder{

        private Context mContext;
        private ICaptureReceiver iCaptureReceiver;
        private EditTypeFactory editTypeFactory;

        public Builder(Context context){
            this.mContext=context;
        }

        public Builder setEditTypeFactory(EditTypeFactory editTypeFactory) {
            this.editTypeFactory = editTypeFactory;
            return this;
        }

        public Builder setCaptureReceiver(ICaptureReceiver receiver){
            this.iCaptureReceiver=receiver;
            return this;
        }


        public AllianceBlock build(){
            return new AllianceBlock(mContext,iCaptureReceiver,editTypeFactory);
        }

    }





    
    
}
