package com.example.chris.materialdesigndemo.module.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.chris.materialdesigndemo.BaseActivity;
import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.adapter.UIStepAdapter;
import com.example.chris.materialdesigndemo.view.DividerItemDecoration;

/**
 * Created by Admin on 2016/7/17.
 */
public class SingleLineWithIconActivity2 extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_single_line_with_icon);
        super.onCreate(savedInstanceState);
        recyclerView = (RecyclerView) findViewById(R.id.slAct_data_rv);
        UIStepAdapter adapter = new UIStepAdapter(this, R.layout.listview_single_line_with_icon2, 10);
        adapter.setOnItemClickListener(new UIStepAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {

            }
        });
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
        recyclerView.setLayoutManager(layoutManager);
    }
}
