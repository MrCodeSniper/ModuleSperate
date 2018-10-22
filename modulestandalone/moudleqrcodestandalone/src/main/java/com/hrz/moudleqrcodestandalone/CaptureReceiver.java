package com.hrz.moudleqrcodestandalone;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/22.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.zxing.receiver.ICaptureReceiver;

//import com.google.zxing.receiver.ICaptureReceiver;

public class CaptureReceiver extends ICaptureReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(this.getClass().getSimpleName(),"onreceive");
    }
}
