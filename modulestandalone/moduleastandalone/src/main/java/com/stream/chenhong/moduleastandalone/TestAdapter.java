package com.stream.chenhong.moduleastandalone;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/11/5.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestViewHolder> {

    private Context context;
    private List list;

    public TestAdapter(Context context, List list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        TestViewHolder testViewHolder=new TestViewHolder(View.inflate(context,R.layout.item_view,null));
        return testViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder testViewHolder, int position) {
        //每个item绑定一个vh



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
