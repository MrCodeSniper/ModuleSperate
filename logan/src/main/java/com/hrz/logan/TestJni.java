package com.hrz.logan;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/22.Best Wishes to You!  []~(~▽~)~* Cheers!


public class TestJni {


    static {
        System.loadLibrary("jni_lib");
    }


    public native int init(String cache_path, String dir_path, int max_file,
                                  String encrypt_key_16, String encrypt_iv_16);
}
