package com.stream.chenhong.moduletest;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/23.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class UniversalLoaderStrategy implements BaseImageLoaderStrategy<ImageConfigImpl> {

    private DisplayImageOptions mImageOptions;

    public UniversalLoaderStrategy(Context context){
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);
        ImageLoader.getInstance().init(configuration);

        mImageOptions = DisplayImageOptions.createSimple();
    }


    @Override
    public void loadImage(Context ctx, ImageConfigImpl config) {
        ImageLoader.getInstance().displayImage(config.url, config.imageView, mImageOptions);
    }

    @Override
    public void clear(Context ctx, ImageConfigImpl config) {

    }
}
