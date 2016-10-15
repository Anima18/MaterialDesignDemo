package com.example.chris.materialdesigndemo.module.cardView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.adapter.UIAdapter;

/**
 * Created by Admin on 2016/7/23.
 */
public class CardViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        recyclerView = (RecyclerView) findViewById(R.id.weekPlanFrm_recyclerView);
        recyclerView.setAdapter(new UIAdapter(this, R.layout.listview_card_item, 20));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
        recyclerView.setLayoutManager(layoutManager);
    }
}
