package com.example.chris.materialdesigndemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.chris.materialdesigndemo.adapter.SwipeAdapter;
import com.example.chris.materialdesigndemo.util.RecyclerUtils;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.malinskiy.superrecyclerview.swipe.SwipeItemManagerInterface;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/9/16.
 */
public class SwipeRecyclerActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, OnMoreListener {

    private static final String LOG = "SwipeRecyclerActivity";
    private SuperRecyclerView mRecycler;
    private Handler mHandler;
    private SwipeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_recycler);
        initView();
        initData();
        initEvent();
    }

    public void initView() {
        initRecyclerview();
    }

    public void initData() {}

    public void initEvent() {}

    public void initRecyclerview() {
        mRecycler = (SuperRecyclerView) findViewById(R.id.list);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> list = new ArrayList<>();
        mAdapter = new SwipeAdapter(list);
        mRecycler.setAdapter(mAdapter);
        mAdapter.setMode(SwipeItemManagerInterface.Mode.Single);
        mRecycler.addOnItemTouchListener(new RecyclerUtils.RecyclerItemClickListener(this, new RecyclerUtils.RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                /*SwipeAdapter.ViewHolder viewHolder = (SwipeAdapter.ViewHolder) view;*/
                //mAdapter.closeAllExcept((SwipeLayout)view);
                mAdapter.closeAllExcept(null);
                new MaterialDialog.Builder(SwipeRecyclerActivity.this)
                        /*.title(R.string.progress_dialog)*/
                        .content("请稍等...")
                        .progress(true, 0)
                        .show();
            }
        }));

        mHandler = new Handler(Looper.getMainLooper());

        mRecycler.setRefreshListener(this);
        mRecycler.setRefreshingColorResources(android.R.color.holo_orange_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_red_light);
        mRecycler.setupMoreListener(this, 1);
    }

    @Override
    public void onRefresh() {
        Toast.makeText(this, "Refresh", Toast.LENGTH_LONG).show();

        Log.i(LOG, "onRefresh");

        mAdapter.closeAllExcept(null);

        mHandler.postDelayed(new Runnable() {
            public void run() {
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);
                mAdapter.insert("New stuff", 0);




            }
        }, 1000);
    }

    @Override
    public void onMoreAsked(int numberOfItems, int numberBeforeMore, int currentItemPos) {
        //Toast.makeText(this, "More", Toast.LENGTH_LONG).show();
        Log.i(LOG, "onMoreAsked,"+numberBeforeMore);

        mHandler.postDelayed(new Runnable() {
            public void run() {
                mAdapter.add("More asked, more served");
                mAdapter.add("More asked, more served");
                mAdapter.add("More asked, more served");
                mAdapter.add("More asked, more served");
                mAdapter.add("More asked, more served");
                mAdapter.add("More asked, more served");
                mAdapter.add("More asked, more served");
                mAdapter.add("More asked, more served");
                mAdapter.add("More asked, more served");
            }
        }, 1000);
    }

}
