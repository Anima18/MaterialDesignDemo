package com.example.chris.materialdesigndemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.chris.materialdesigndemo.util.SystemBarTintManager;

/**
 * Created by Admin on 2016/10/21.
 */

public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private int layoutId;

    protected void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        initStatusBar();
        initToolBar();
    }

    public void initToolBar() {

        toolbar = (Toolbar) findViewById(R.id.activity_toolBar);
        // App Logo
        //toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        //toolbar.setTitle("NavigationView");
        // Sub Title
        //toolbar.setSubtitle("Sub title");
        setSupportActionBar(toolbar);

        /*final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);*/
    }

    public void initStatusBar() {
        //        设定状态栏的颜色，当版本大于4.4时起作用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorPrimary);
        }
    }

    protected void setTitle(String title) {
        toolbar.setTitle(title);
    }
}
