package com.example.chris.materialdesigndemo.module.gridView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.adapter.UIAdapter;

/**
 * Created by Admin on 2016/7/23.
 */
public class GridViewSingleLineOnlyTextActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        recyclerView = (RecyclerView) findViewById(R.id.weekPlanFrm_recyclerView);
        recyclerView.setAdapter(new UIAdapter(this, R.layout.listview_grid_single_line_only_text, 20));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}