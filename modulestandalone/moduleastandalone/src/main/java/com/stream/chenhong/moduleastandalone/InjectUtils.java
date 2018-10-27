package com.stream.chenhong.moduleastandalone;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/27.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class InjectUtils {
    /**
     * JSBRIDGE的文本 用来注入
     * @param context
     * @return
     */
    public static String getJsCode(Context context) {

        String str = "";
        try {
            InputStream is = context.getAssets().open("hrz_jsb_new.js");
            int lenght = 0;
            lenght = is.available();
            byte[] buffer = new byte[lenght];
            is.read(buffer);
            str = new String(buffer, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}
