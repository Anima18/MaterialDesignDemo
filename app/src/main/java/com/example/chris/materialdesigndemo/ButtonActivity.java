package com.example.chris.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by Admin on 2016/7/21.
 */
public class ButtonActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_button);
        super.onCreate(savedInstanceState);
    }

    public void FABClick(View view) {}
}
