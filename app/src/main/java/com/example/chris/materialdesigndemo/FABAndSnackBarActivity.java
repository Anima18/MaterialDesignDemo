package com.example.chris.materialdesigndemo;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.chris.materialdesigndemo.adapter.UIAdapter;
import com.example.chris.materialdesigndemo.view.DividerItemDecoration;

/**
 * Created by Admin on 2015/8/22.
 */
public class FABAndSnackBarActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton addFab;
    private RecyclerView rvUsers;
    private CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_fab);
        initView();
        initEnvent();
    }

    public void initView() {
        initRecyclerview();

        addFab = (FloatingActionButton) findViewById(R.id.activity_fab_addFad);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_fab_coordinatorLayout);
    }

    public void initEnvent() {
        addFab.setOnClickListener(this);
    }

    public void initRecyclerview() {
        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView;
        recyclerView = (RecyclerView) findViewById(R.id.lvToDoList);
        UIAdapter adapter = new UIAdapter(this, R.layout.listview_two_line_only_text, 20);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_showSnackBar :
                Snackbar.make(coordinatorLayout, "They also display at the bottom of the screen, but may not be swiped off-screen.", Snackbar.LENGTH_LONG).setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(FABAndSnackBarActivity.this, "snackBar click", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_fab_addFad :
                Toast.makeText(this, "FAB click", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
