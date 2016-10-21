package com.example.chris.materialdesigndemo.module.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chris.materialdesigndemo.BaseActivity;
import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.adapter.UIAdapter;

/**
 * Created by Admin on 2016/7/23.
 */
public class GridViewSingleLineWithIconActivity extends BaseActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_grid_view);
        super.onCreate(savedInstanceState);
        recyclerView = (RecyclerView) findViewById(R.id.weekPlanFrm_recyclerView);
        recyclerView.setAdapter(new UIAdapter(this, R.layout.listview_grid_single_line_with_icon, 20));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
