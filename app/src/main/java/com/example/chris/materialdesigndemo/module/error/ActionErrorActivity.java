package com.example.chris.materialdesigndemo.module.error;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.chris.materialdesigndemo.BaseActivity;
import com.example.chris.materialdesigndemo.R;

/**
 * Created by Admin on 2016/10/21.
 */

public class ActionErrorActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setLayoutId(R.layout.toolbar_common);
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
                new MaterialDialog.Builder(ActionErrorActivity.this)
                        .title("Action Error")
                        .content("操作错误，一般有3种情况：\n1. 载入数据错误，参考Empty State。\n2. 提交错误，一般显示SnackBar，包含错误信息和操作。\n3. 应用错误，显示dialog。")
                        .positiveText("agree")
                        .negativeText("disagree")
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
