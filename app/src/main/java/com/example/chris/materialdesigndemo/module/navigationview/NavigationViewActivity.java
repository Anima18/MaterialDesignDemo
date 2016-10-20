package com.example.chris.materialdesigndemo.module.navigationview;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.module.tabview.FragmentTab1;
import com.example.chris.materialdesigndemo.module.tabview.FragmentTab2;
import com.example.chris.materialdesigndemo.module.tabview.FragmentTab3;
import com.example.chris.materialdesigndemo.util.SystemBarTintManager;


public class NavigationViewActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        initStatusBar();
        initToolBar();
        initNavigationView();
    }

    public void initToolBar() {

        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        // App Logo
        //toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        toolbar.setTitle("NavigationView");
        // Sub Title
        //toolbar.setSubtitle("Sub title");
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void initStatusBar() {
        //        设定状态栏的颜色，当版本大于4.4时起作用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorPrimary);
        }
    }

    public void initNavigationView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_nv_menu);
       /* Menu navMenu = mNavigationView.getMenu();
        navMenu.getItem(0).getGroupId();
        navMenu.add(R.id.nav_group, 10001, Menu.NONE, "Dynamic Item1").setIcon(R.drawable.ic_send_white_24dp).setCheckable(true);
        navMenu.add(R.id.nav_group, 10002, Menu.NONE, "Dynamic Item2").setIcon(R.drawable.ic_text_format_white_24dp).setCheckable(true);
        navMenu.setGroupCheckable(R.id.nav_group, true, true);*/
        setupDrawerContent(mNavigationView);
    }

    private void setupDrawerContent(NavigationView navigationView)  {
        selectItem(navigationView.getMenu().getItem(0));
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectItem(menuItem);
                        return true;
                    }
                });
    }

    private void selectItem(MenuItem menuItem) {
        // update the main content by replacing fragments
        Fragment fragment = getFragment(menuItem);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_mian_content_frame, fragment).commitAllowingStateLoss();

        // update selected item and title, then close the drawer
        menuItem.setChecked(true);
        toolbar.setTitle(menuItem.getTitle());
        //getSupportActionBar().setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();
    }

    private Fragment getFragment(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                return new FragmentTab1();
            case R.id.nav_messages:
                return new FragmentTab2();
            default:
                return new FragmentTab3();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true ;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
