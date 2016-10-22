package com.example.chris.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

/**
 * Created by Admin on 2016/10/22.
 */

public class LaunchScreenActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_launch);
        super.onCreate(savedInstanceState);
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(LaunchScreenActivity.this,MainActivity.class);
                LaunchScreenActivity.this.startActivity(mainIntent);
                LaunchScreenActivity.this.finish();
            }
        }, 2000);
    }
}
