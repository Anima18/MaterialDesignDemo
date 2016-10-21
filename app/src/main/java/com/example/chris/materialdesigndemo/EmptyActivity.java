package com.example.chris.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by Admin on 2016/10/21.
 */

public class EmptyActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_empty);
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.act_info:
                new MaterialDialog.Builder(EmptyActivity.this)
                        .title("About Empty state")
                        .content("当没有数据的时候，需要显示空状态。空状态一般由非交互性、中性的图片和提示文字组成。")
                        .positiveText("agree")
                        .negativeText("disagree")
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
