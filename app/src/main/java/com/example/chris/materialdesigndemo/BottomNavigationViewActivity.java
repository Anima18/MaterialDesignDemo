package com.example.chris.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.chris.materialdesigndemo.module.tabview.FragmentTab1;
import com.example.chris.materialdesigndemo.module.tabview.FragmentTab2;
import com.example.chris.materialdesigndemo.module.tabview.FragmentTab3;

/**
 * Created by jianjianhong on 2016/12/2.
 */

public class BottomNavigationViewActivity extends BaseActivity {

    private BottomNavigationView navigationView;
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    private Fragment fragment4;
    private Fragment fragment5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_bottom_navigation);
        super.onCreate(savedInstanceState);

        navigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_home:
                        if(fragment1 == null) {
                            fragment1 = new FragmentTab1();
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment1).commitAllowingStateLoss();
                        toolbar.setTitle(item.getTitle());
                        break;
                    case R.id.bottom_nav_role:
                        if(fragment2 == null) {
                            fragment2 = new FragmentTab2();
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment2).commitAllowingStateLoss();
                        toolbar.setTitle(item.getTitle());
                        break;
                    case R.id.bottom_nav_plan:
                        if(fragment3 == null) {
                            fragment3 = new FragmentTab3();
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment3).commitAllowingStateLoss();
                        toolbar.setTitle(item.getTitle());
                        break;
                    case R.id.bottom_nav_idea:
                        if(fragment4 == null) {
                            fragment4 = new FragmentTab3();
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment4).commitAllowingStateLoss();
                        toolbar.setTitle(item.getTitle());
                        break;
                    case R.id.bottom_nav_me:
                        if(fragment5 == null) {
                            fragment5 = new FragmentTab3();
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment5).commitAllowingStateLoss();
                        toolbar.setTitle(item.getTitle());
                        break;
                }
                return true;
            }
        });
    }
}
