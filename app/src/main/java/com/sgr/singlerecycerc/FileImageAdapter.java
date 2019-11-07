package com.sgr.singlerecycerc;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sgr.singlerecycerc.R;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;




/**
 * Created by Administrator on 2017/8/24.
 */


public class FileImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemClickListener{
    Context contexts;
    public static Set<Integer> positionSet = new HashSet<>();
    int mlastPosition, mcurPositon;
    public FileImageAdapter(Context context) {
        super(R.layout.item_image, null);
        contexts=context;
    }

    public void setpositionSet(Set<Integer> positionSets){
        this.positionSet=positionSets;


    }

    public void setPosition(int lastPosition,int curPositon){
        this.mlastPosition=lastPosition;
        this.mcurPositon=curPositon;

    }
    @Override
    protected void convert(BaseViewHolder baseViewHolder, String photos) {

//        Photo  photo=(Photo) photos;
        ImageView tempView= baseViewHolder.getView(R.id.file_img);
        ImageView selectImage= baseViewHolder.getView(R.id.select_img);

        if (positionSet.contains(baseViewHolder.getAdapterPosition())) {
            selectImage.setVisibility(View.VISIBLE);
        } else {
            selectImage.setVisibility(View.GONE);
        }
        Glide.with(contexts).load(R.mipmap.ic_launcher_round)
             .into(tempView);

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
    }


}