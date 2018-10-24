package com.stream.chenhong.moduletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_test=findViewById(R.id.iv_test);


        BaseImageLoaderStrategy baseImageLoaderStrategy=new UniversalLoaderStrategy(this);


        ImageLoaderUtils.newInstance(new UniversalLoaderStrategy(this)).loadImage(this,ImageConfigImpl
                .builder()
                .placeholder(R.mipmap.ic_launcher)
                .isCrossFade(true)
                .errorPic(R.mipmap.ic_launcher)
                .url("https://avatar.csdn.net/A/C/4/2_s63857952.jpg")
                .imageView(iv_test)
                .build());





    }
}
