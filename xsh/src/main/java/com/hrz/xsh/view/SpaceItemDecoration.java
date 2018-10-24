package com.hrz.xsh.view;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/10/24.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int decoration;


    public SpaceItemDecoration(int decoration) {
        this.decoration = decoration;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.left=decoration;
        outRect.right=decoration;
        outRect.bottom=decoration;

        if(parent.getChildPosition(view)==0){
            outRect.top=decoration;
        }

    }
}
