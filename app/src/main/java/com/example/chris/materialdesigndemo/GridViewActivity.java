package com.example.chris.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.chris.materialdesigndemo.adapter.MainAdapter;
import com.example.chris.materialdesigndemo.entity.ActivityClass;
import com.example.chris.materialdesigndemo.module.gridView.GridViewOnlyImageActivity;
import com.example.chris.materialdesigndemo.module.gridView.GridViewSingleLineOnlyTextActivity;
import com.example.chris.materialdesigndemo.module.gridView.GridViewSingleLineWithIconActivity;
import com.example.chris.materialdesigndemo.module.gridView.GridViewTwoLineOnlyTextActivity;
import com.example.chris.materialdesigndemo.module.gridView.GridViewTwoLineWithIconActivity;
import com.example.chris.materialdesigndemo.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/7/24.
 */
public class GridViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<ActivityClass> activityClassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initEvent();
    }

    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.mainAct_data_rv);
        MainAdapter adapter = new MainAdapter(this, activityClassList);
        adapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                ActivityClass activityClass = activityClassList.get(position);
                if(activityClass.getActivityClass() == null) {
                    Toast.makeText(GridViewActivity.this, "没有实现", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(GridViewActivity.this, activityClass.getActivityClass());
                    startActivity(intent);
                }
            }
        });
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
        recyclerView.setLayoutManager(layoutManager);
    }

    public void initData() {
        activityClassList = new ArrayList<>();

        activityClassList.add(new ActivityClass("Only image", GridViewOnlyImageActivity.class));
        activityClassList.add(new ActivityClass("Single-line only text", GridViewSingleLineOnlyTextActivity.class));
        activityClassList.add(new ActivityClass("Single-line text with icon", GridViewSingleLineWithIconActivity.class));
        activityClassList.add(new ActivityClass("Two-line only text", GridViewTwoLineOnlyTextActivity.class));
        activityClassList.add(new ActivityClass("Two-line text with icon", GridViewTwoLineWithIconActivity.class));
    }

    public void initEvent() {

    }
}
