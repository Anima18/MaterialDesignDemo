package com.example.chris.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.chris.materialdesigndemo.adapter.MainAdapter;
import com.example.chris.materialdesigndemo.entity.ActivityClass;
import com.example.chris.materialdesigndemo.module.cardview.CardView2Activity;
import com.example.chris.materialdesigndemo.module.cardview.CardView3Activity;
import com.example.chris.materialdesigndemo.module.cardview.CardView4Activity;
import com.example.chris.materialdesigndemo.module.cardview.CardView5Activity;
import com.example.chris.materialdesigndemo.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/7/24.
 */
public class CardViewActivity extends BaseActivity {
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
                if(activityClass.getActivityClass() == null) {
                    Toast.makeText(CardViewActivity.this, "没有实现", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(CardViewActivity.this, activityClass.getActivityClass());
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

        activityClassList.add(new ActivityClass("CardView", com.example.chris.materialdesigndemo.module.cardview.CardViewActivity.class));
        activityClassList.add(new ActivityClass("CardView2", CardView2Activity.class));
        activityClassList.add(new ActivityClass("CardView3", CardView3Activity.class));
        activityClassList.add(new ActivityClass("CardView4", CardView4Activity.class));
        activityClassList.add(new ActivityClass("CardView5", CardView5Activity.class));
    }

    public void initEvent() {

    }
}
