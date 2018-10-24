package com.hrz.xsh.controller;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/24.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;
import android.util.Log;

import com.hrz.xsh.block.AllianceBlock;
import com.hrz.xsh.entity.AllianceHomeShopsEntity;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AlliaceController {



    private Context mContext;
    private AllianceBlock mCaptureBlock;
    private AllianceBlock.EditTypeFactory editTypeFactory;

    /**
     *
     * @param context
     * @param block  拿block里的view
     * @param editTypeFactory 用这个创建数据源
     */
    public AlliaceController(Context context, AllianceBlock block, AllianceBlock.EditTypeFactory editTypeFactory){
        this.mCaptureBlock=block;
        this.mContext=context;
        this.editTypeFactory=editTypeFactory;
    }


    /**
     * controller将 调用请求后的结果交给view
     */
    public void load(Map<String,String> map){

        if(editTypeFactory==null){
            Log.e("AlliaceController","askAndAnswerEditorController==null");
            return;
        }

        editTypeFactory.getSubmitObservable(mContext,map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<AllianceHomeShopsEntity>() {
                @Override
                public void accept(AllianceHomeShopsEntity allianceHomeShopsEntity) throws Exception {
                    mCaptureBlock.bindData(allianceHomeShopsEntity);
                }
            });
        }

    }






