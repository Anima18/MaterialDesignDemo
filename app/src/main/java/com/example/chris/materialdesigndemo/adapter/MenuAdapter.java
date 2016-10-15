package com.example.chris.materialdesigndemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chris.materialdesigndemo.R;

/**
 * Created by Admin on 2016/8/6.
 */
public class MenuAdapter extends BaseAdapter {

    private Context context;
    private int layoutId;
    private int itemSize;
    private int selected = -1;

    public MenuAdapter(Context context, int layoutId, int itemSize) {
        this.context = context;
        this.layoutId = layoutId;
        this.itemSize = itemSize;
    }
    @Override
    public int getCount() {
        return itemSize;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(layoutId, null);
        TextView textView = (TextView) view.findViewById(R.id.menuList_text);
        textView.setText(i+"");

        if(selected == i) {
            textView.setBackgroundColor(context.getResources().getColor(R.color.colorBackground));
        } else {
            textView.setBackgroundColor(Color.TRANSPARENT);
        }

        return view;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
