package com.mujirenben.android.poplayer.bean;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/27.Best Wishes to You!  []~(~▽~)~* Cheers!

import android.view.View;

/**
 *  窗口的最小不可分割实体
 */
public class Popi {


    private int popId;

    private PopType mType;

    //是否弹窗可以取消
    private boolean isPopCanCancel=true;

    //弹窗显示方式 0为点击取消（需要设置显示次数） 1为计时取消(需要设置显示时间)
    private int showType;
    private int maxShowTime;
    private int maxShowCount;

    //弹窗内容视图 可为空
    private View contentView;



    //时间撮形式的开始时间和结束时间
    private long beginDate;
    private long endDate;



    //优先级 数值越小 优先级越高
    private int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
