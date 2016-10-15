package com.example.chris.materialdesigndemo.module.listView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chris.materialdesigndemo.view.DividerItemDecoration;
import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.adapter.UIAdapter;

/**
 * Created by Admin on 2016/7/17.
 */
public class ThreeLineWithAvatarAndIconActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_line_with_avatar);
        recyclerView = (RecyclerView) findViewById(R.id.slaAct_data_rv);
        UIAdapter adapter = new UIAdapter(this, R.layout.listview_three_line_with_avatar_and_icon, 20);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.DIVIDER_TYPE_INSET, layoutManager.getOrientation()));
        recyclerView.setLayoutManager(layoutManager);
    }
}
