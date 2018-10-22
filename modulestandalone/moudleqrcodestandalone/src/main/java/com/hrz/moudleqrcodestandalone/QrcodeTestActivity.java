package com.hrz.moudleqrcodestandalone;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/22.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.google.zxing.interf.OnTestClickListener;
import com.google.zxing.self.util.StatusBarUtil;
import com.google.zxing.view.CapturePage;
import com.stream.chenhong.modulea.ModuleaActivity;

public class QrcodeTestActivity extends BaseLifecycleActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarTransparent(this);
        CapturePage capturePage=new CapturePage(this,new CaptureReceiver());
        capturePage.setClickListener(new OnTestClickListener() {
            @Override
            public void test() {
                Toast.makeText(QrcodeTestActivity.this,"xxx",Toast.LENGTH_LONG).show();
                startActivity(new Intent(QrcodeTestActivity.this, ModuleaActivity.class));
            }
        });
        setContentView(capturePage);
    }




}
