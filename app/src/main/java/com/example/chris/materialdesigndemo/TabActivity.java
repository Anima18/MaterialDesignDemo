package com.example.chris.materialdesigndemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.chris.materialdesigndemo.adapter.ViewPagerAdapter;
import com.example.chris.materialdesigndemo.entity.Message;
import com.example.chris.materialdesigndemo.module.tabview.FragmentTab1;
import com.example.chris.materialdesigndemo.module.tabview.FragmentTab2;
import com.example.chris.materialdesigndemo.module.tabview.FragmentTab3;
import com.example.chris.materialdesigndemo.view.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class TabActivity extends BaseActivity {

    static final String LOG_TAG = "SlidingTabsBasicFragment";
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_tab);
        super.onCreate(savedInstanceState);
        //以下代码用于去除阴影
        /*if(Build.VERSION.SDK_INT>=21){
            getSupportActionBar().setElevation(0);
        }*/
        getSupportActionBar().setElevation(0);
        initTabView();
    }


    public void initTabView() {
        mSpinner = (Spinner) findViewById(R.id.toolbar_spinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String)adapterView.getSelectedItem();
                Log.i("Chris", value);
                EventBus.getDefault().post(new Message(value));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new FragmentTab1());
        fragmentList.add(new FragmentTab2());
        fragmentList.add(new FragmentTab3());
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tab_text_inactive);
            }
        });
        mSlidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(TabActivity.this, "热门推荐" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //mSlidingTabLayout.setDividerColors(R.color.primary);
    }
}
