package com.example.chris.materialdesigndemo.module.cardview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chris.materialdesigndemo.BaseActivity;
import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.adapter.UIAdapter;

/**
 * Created by Admin on 2016/7/23.
 */
public class CardView4Activity extends BaseActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_card_view);
        super.onCreate(savedInstanceState);
        recyclerView = (RecyclerView) findViewById(R.id.weekPlanFrm_recyclerView);
        recyclerView.setAdapter(new UIAdapter(this, R.layout.listview_card_item4, 20));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
        recyclerView.setLayoutManager(layoutManager);
    }
}
