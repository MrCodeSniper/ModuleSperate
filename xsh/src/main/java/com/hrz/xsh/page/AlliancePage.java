package com.hrz.xsh.page;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/19.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hrz.xsh.block.AllianceBlock;
import com.hrz.xsh.factory.AllianceFactory;
import com.hrz.xsh.receiver.ICaptureReceiver;


/**
 * 就是个容器
 */
public class AlliancePage extends LinearLayout{


    private AllianceBlock allianceBlock;

    public AlliancePage(Context context, ICaptureReceiver receiver) {
        super(context);
        allianceBlock=getRcViewBlock(context,receiver);
        addView(allianceBlock,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
    }

    private AllianceBlock getRcViewBlock(Context context, ICaptureReceiver receiver){
        return new AllianceBlock.Builder(context)
                .setCaptureReceiver(receiver)
                .setEditTypeFactory(new AllianceFactory())
                .build();
    }



}
