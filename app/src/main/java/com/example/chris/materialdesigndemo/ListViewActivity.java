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
import com.example.chris.materialdesigndemo.module.listView.SingleLineWithAvatarActivity;
import com.example.chris.materialdesigndemo.module.listView.SingleLineWithAvatarAndIconActivity;
import com.example.chris.materialdesigndemo.module.listView.SingleLineWithIconActivity;
import com.example.chris.materialdesigndemo.module.listView.ThreeLineOnlyTextActivity;
import com.example.chris.materialdesigndemo.module.listView.ThreeLineWithAvatarActivity;
import com.example.chris.materialdesigndemo.module.listView.ThreeLineWithAvatarAndIconActivity;
import com.example.chris.materialdesigndemo.module.listView.ThreeLineWithIconActivity;
import com.example.chris.materialdesigndemo.module.listView.TwoLineOnlyTextActivity;
import com.example.chris.materialdesigndemo.module.listView.TwoLineWithAvatarActivity;
import com.example.chris.materialdesigndemo.module.listView.TwoLineWithAvatarAndIconActivity;
import com.example.chris.materialdesigndemo.module.listView.TwoLineWithIconActivity;
import com.example.chris.materialdesigndemo.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/7/24.
 */
public class ListViewActivity extends AppCompatActivity {
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
