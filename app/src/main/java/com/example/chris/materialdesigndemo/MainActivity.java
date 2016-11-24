package com.example.chris.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.chris.materialdesigndemo.adapter.MainAdapter;
import com.example.chris.materialdesigndemo.entity.ActivityClass;
import com.example.chris.materialdesigndemo.module.navigationview.NavigationViewActivity;
import com.example.chris.materialdesigndemo.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

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
        setTitle("MaterialDesignDemo");

        recyclerView = (RecyclerView) findViewById(R.id.mainAct_data_rv);
        MainAdapter adapter = new MainAdapter(this, activityClassList);
        adapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                ActivityClass activityClass = activityClassList.get(position);
                if(activityClass.getActivityName().equals("Dialog")) {
                    new MaterialDialog.Builder(MainActivity.this)
                            .title("About Material Dialog")
                            .content("Please refer to this libraries: https://github.com/afollestad/material-dialogs")
                            .positiveText("agree")
                            .negativeText("disagree")
                            .show();
                }else if(activityClass.getActivityClass() == null) {
                    Toast.makeText(MainActivity.this, "没有实现", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, activityClass.getActivityClass());
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

        activityClassList.add(new ActivityClass("ListView", ListViewActivity.class));
        activityClassList.add(new ActivityClass("button", ButtonActivity.class));
        activityClassList.add(new ActivityClass("CardView", CardViewActivity.class));
        activityClassList.add(new ActivityClass("Dialog", null));
        activityClassList.add(new ActivityClass("GridView", GridViewActivity.class));
        activityClassList.add(new ActivityClass("Menu", MenuActivity.class));
        activityClassList.add(new ActivityClass("SwipeRecycler", SwipeRecyclerActivity.class));
        activityClassList.add(new ActivityClass("Selection", SelectionActivity.class));
        activityClassList.add(new ActivityClass("Tab", TabActivity.class));
        activityClassList.add(new ActivityClass("Snackbars & toasts", FABAndSnackBarActivity.class));
        activityClassList.add(new ActivityClass("Steppers", null));
        activityClassList.add(new ActivityClass("Subheaders", null));
        activityClassList.add(new ActivityClass("Empty states", EmptyActivity.class));
        activityClassList.add(new ActivityClass("Errors", ErrorListActivity.class));
        activityClassList.add(new ActivityClass("Launch screens", LaunchScreenActivity.class));
        activityClassList.add(new ActivityClass("Navigation drawer", NavigationViewActivity.class));
        activityClassList.add(new ActivityClass("Scrolling techniques", null));
        activityClassList.add(new ActivityClass("Search", null));
        activityClassList.add(new ActivityClass("Settings", null));
        activityClassList.add(new ActivityClass("Introduce", GuideActivity.class));
    }

    public void initEvent() {

    }

}
