package com.sgr.singlerecycerc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemClickListener{
  FileImageAdapter mFileAdater;
    int mlastPosition, mcurPositon;
    public static Set<Integer> positionSet = new HashSet<>();//recyclerView 单选的集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView image_rv = (RecyclerView)findViewById(R.id.ablum_rv);
        mFileAdater = new FileImageAdapter(this);
        mFileAdater.setOnItemClickListener(this);
        image_rv.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
        image_rv.setAdapter(mFileAdater);
        List<String> temp= new ArrayList<String>();
        for(int i=0;i<40;i++){
            temp.add(i+"");
        }
        mFileAdater.setNewData(temp);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        addOrRemove(position);
    }
    private void addOrRemove(int position) {
        if (!positionSet.contains(position)) {
            // 选择不同的单位时取消之前选中的单位
            positionSet.clear();
        }
        if (positionSet.contains(position)) {
            // 如果包含，则撤销选择
            positionSet.remove(position);
        } else {
            // 如果不包含，则添加
            positionSet.add(position);
        }
        // 更新列表界面，否则无法显示已选的item
        mlastPosition = mcurPositon;
        mcurPositon = position;
        mFileAdater.setpositionSet(positionSet);
        mFileAdater.notifyItemChanged(mlastPosition);
        mFileAdater.notifyItemChanged(mcurPositon);


    }
}
