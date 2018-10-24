package com.stream.chenhong.moduletest;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/23.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;

public class ImageLoaderUtils implements BaseImageLoaderStrategy{


    private BaseImageLoaderStrategy baseImageLoaderStrategy;

    private static ImageLoaderUtils instance;

    public static ImageLoaderUtils newInstance(BaseImageLoaderStrategy imageLoaderStrategy) {
        if (instance == null) {
            synchronized (ImageLoaderUtils.class) {
                if (instance == null) {
                    instance = new ImageLoaderUtils(imageLoaderStrategy);
                }
            }
        }
        return instance;
    }

    private ImageLoaderUtils(BaseImageLoaderStrategy specificLoaderStrategy){
        this.baseImageLoaderStrategy=specificLoaderStrategy;
    }


    @Override
    public void loadImage(Context ctx, ImageConfig config) {
        baseImageLoaderStrategy.loadImage(ctx,config);
    }

    @Override
    public void clear(Context ctx, ImageConfig config) {
        baseImageLoaderStrategy.clear(ctx,config);
    }
}
