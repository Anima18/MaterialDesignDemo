package com.example.chris.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.chris.materialdesigndemo.adapter.MainAdapter;
import com.example.chris.materialdesigndemo.entity.ActivityClass;
import com.example.chris.materialdesigndemo.module.listview.SingleLineWithAvatarActivity;
import com.example.chris.materialdesigndemo.module.listview.SingleLineWithAvatarAndIconActivity;
import com.example.chris.materialdesigndemo.module.listview.SingleLineWithIconActivity;
import com.example.chris.materialdesigndemo.module.listview.ThreeLineOnlyTextActivity;
import com.example.chris.materialdesigndemo.module.listview.ThreeLineWithAvatarActivity;
import com.example.chris.materialdesigndemo.module.listview.ThreeLineWithAvatarAndIconActivity;
import com.example.chris.materialdesigndemo.module.listview.ThreeLineWithIconActivity;
import com.example.chris.materialdesigndemo.module.listview.TwoLineOnlyTextActivity;
import com.example.chris.materialdesigndemo.module.listview.TwoLineWithAvatarActivity;
import com.example.chris.materialdesigndemo.module.listview.TwoLineWithAvatarAndIconActivity;
import com.example.chris.materialdesigndemo.module.listview.TwoLineWithIconActivity;
import com.example.chris.materialdesigndemo.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/7/24.
 */
public class ListViewActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private List<ActivityClass> activityClassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_main);
        super.onCreate(savedInstanceState);
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
                if(activityClass.getActivityClass() == ListViewActivity.class) {
                    Toast.makeText(ListViewActivity.this, "首页列表", Toast.LENGTH_SHORT).show();
                }else if(activityClass.getActivityClass() == null) {
                    Toast.makeText(ListViewActivity.this, "没有实现", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(ListViewActivity.this, activityClass.getActivityClass());
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

        activityClassList.add(new ActivityClass("Single-line list only text", ListViewActivity.class));
        activityClassList.add(new ActivityClass("Single-line list with icon", SingleLineWithIconActivity.class));
        activityClassList.add(new ActivityClass("Single-line list whit avatar", SingleLineWithAvatarActivity.class));
        activityClassList.add(new ActivityClass("Single-line list whit avatar and icon", SingleLineWithAvatarAndIconActivity.class));
        activityClassList.add(new ActivityClass("Two-line list whit only text", TwoLineOnlyTextActivity.class));
        activityClassList.add(new ActivityClass("Two-line list whit icon", TwoLineWithIconActivity.class));
        activityClassList.add(new ActivityClass("Two-line list whit avatar", TwoLineWithAvatarActivity.class));
        activityClassList.add(new ActivityClass("Two-line list whit avatar and icon", TwoLineWithAvatarAndIconActivity.class));
        activityClassList.add(new ActivityClass("Three-line list whit only text", ThreeLineOnlyTextActivity.class));
        activityClassList.add(new ActivityClass("Three-line list whit icon", ThreeLineWithIconActivity.class));
        activityClassList.add(new ActivityClass("Three-line list whit avatar", ThreeLineWithAvatarActivity.class));
        activityClassList.add(new ActivityClass("Three-line list whit avatar and icon", ThreeLineWithAvatarAndIconActivity.class));
    }

    public void initEvent() {

    }
}
