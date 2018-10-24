package com.hrz.xsh.factory;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/19.Best Wishes to You!  []~(~▽~)~* Cheers!

import android.content.Context;

import com.hrz.xsh.block.AllianceBlock;
import com.hrz.xsh.service.AllianceService;
import com.hrz.xsh.utils.RetrofitUtil;

import java.util.Map;

/**
 * 专门产出数据的工厂 作为builder的一部分传入
 */
public class AllianceFactory implements AllianceBlock.EditTypeFactory{


    /*
    * 构造方法接受参数
     */
    public AllianceFactory() {

    }


    //异步获取数据返回
    @Override
    public io.reactivex.Observable getSubmitObservable(Context context, Map<String, String> options) {
        return RetrofitUtil.getRetrofitUtils().createRequest(AllianceService.class)
                .getAllianceHomeShops(options);
    }

    //接受异步获取的数据并更新ui
    @Override
    public void updateAndSync(Context context, Object o) {

    }

    @Override
    public String getOldContent(Context context) {
        return null;
    }
}
