package com.example.chris.materialdesigndemo.module.tabview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.entity.Message;

import de.greenrobot.event.EventBus;


/**
 * Created by Admin on 2015/8/15.
 */
public class FragmentTab1 extends Fragment {

    private final static String TAG = "Chris";
    private View rootView;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        if(rootView == null) {
            Log.i(TAG, "create rootView");
            rootView =  inflater.inflate(R.layout.fragment_tab1, container, false);
            textView = (TextView) rootView.findViewById(R.id.tab1);
            EventBus.getDefault().register(this);
        }

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(Message event) {
        textView.setText(event.getName());
    }
}
