package com.stream.chenhong.moduletest.net;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/24.Best Wishes to You!  []~(~▽~)~* Cheers!


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkApi {
    @GET("/path/to/api")
    Call<List<Photo>> getAllPhotos();
}