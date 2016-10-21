package com.example.chris.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Admin on 2016/10/21.
 */

public class EmptyActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_empty);
        super.onCreate(savedInstanceState);
    }
}
