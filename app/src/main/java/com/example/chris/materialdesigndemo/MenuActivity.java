package com.example.chris.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ListPopupWindow;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.chris.materialdesigndemo.adapter.MenuAdapter;

/**
 * Created by Admin on 2016/8/4.
 */
public class MenuActivity extends BaseActivity implements View.OnClickListener {

    private Button menuButton;
    ListPopupWindow listPopupWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_menu);
        super.onCreate(savedInstanceState);

        menuButton = (Button)findViewById(R.id.menuAct_button);
        menuButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menuAct_button:
                showListPopupWidow();
                break;
        }
    }

    private void showListPopupWidow() {
        String items[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        listPopupWindow = new ListPopupWindow(this);

        // ListView适配器
        /*listPopupWindow.setAdapter(
                new ArrayAdapter<String>(getApplicationContext(), R.layout.listview_menu_item, items));*/

        MenuAdapter adapter = new MenuAdapter(this, R.layout.listview_menu_item, 10);
        listPopupWindow.setAdapter(adapter);



        // 选择item的监听事件
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(getApplicationContext(), "选择:" + pos, Toast.LENGTH_SHORT).show();
                menuButton.setText(pos+"");
                listPopupWindow.dismiss();
            }
        });

        // 对话框的宽高
        listPopupWindow.setWidth(this.getResources().getDimensionPixelSize(R.dimen.menuAct_menu_width));
        listPopupWindow.setHeight(600);

        // ListPopupWindow的锚,弹出框的位置是相对当前View的位置
        listPopupWindow.setAnchorView(menuButton);

        // ListPopupWindow 距锚view的距离
        /*listPopupWindow.setHorizontalOffset(50);*/
        listPopupWindow.setVerticalOffset(-menuButton.getHeight());

        listPopupWindow.setModal(true);

        listPopupWindow.show();
        int selected = Integer.parseInt(menuButton.getText().toString());
        listPopupWindow.setSelection(selected);
        adapter.setSelected(selected);
    }
}
