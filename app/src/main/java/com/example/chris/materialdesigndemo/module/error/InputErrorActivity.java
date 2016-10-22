package com.example.chris.materialdesigndemo.module.error;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.chris.materialdesigndemo.BaseActivity;
import com.example.chris.materialdesigndemo.R;
import com.example.chris.materialdesigndemo.util.DateUtil;
import com.example.chris.materialdesigndemo.util.StringUtil;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by Admin on 2016/10/21.
 */

public class InputErrorActivity extends BaseActivity implements View.OnClickListener, View.OnFocusChangeListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private TextInputLayout titleTi;
    private EditText titleEt;
    private TextInputLayout descTi;
    private EditText descEt;
    private TextInputLayout labelTi;
    private EditText labelEt;
    private TextInputLayout roleTi;
    private EditText roleEt;
    private TextInputLayout quadrantTi;
    private EditText quadrantEt;
    private TextInputLayout fromDateTi;
    private EditText fromDateEt;
    private TextInputLayout fromTimeTi;
    private EditText fromTimeEt;
    private Button saveBt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_input_error);
        super.onCreate(savedInstanceState);

        initView();
        initEvent();
    }

    private void initView() {
        titleTi = (TextInputLayout) findViewById(R.id.tcAct_title_ti);
        descTi = (TextInputLayout) findViewById(R.id.tcAct_desc_ti);
        labelTi = (TextInputLayout) findViewById(R.id.tcAct_label_ti);
        roleTi = (TextInputLayout) findViewById(R.id.tcAct_role_ti);
        quadrantTi = (TextInputLayout) findViewById(R.id.tcAct_quadrant_ti);
        fromDateTi = (TextInputLayout) findViewById(R.id.tcAct_begin_date_ti);
        fromTimeTi = (TextInputLayout) findViewById(R.id.tcAct_begin_time_ti);

        titleEt = (EditText) findViewById(R.id.tcAct_title_et);
        descEt = (EditText) findViewById(R.id.tcAct_desc_et);
        labelEt = (EditText) findViewById(R.id.tcAct_label_et);
        roleEt = (EditText) findViewById(R.id.tcAct_role_et);
        quadrantEt = (EditText) findViewById(R.id.tcAct_quadrant_et);
        fromDateEt = (EditText) findViewById(R.id.tcAct_begin_date_et);
        fromTimeEt = (EditText) findViewById(R.id.tcAct_begin_time_et);

        saveBt = (Button) findViewById(R.id.tcAct_save_bt);
    }

    private void initEvent() {
        labelEt.setOnFocusChangeListener(this);
        labelEt.setOnClickListener(this);
        roleEt.setOnClickListener(this);
        roleEt.setOnFocusChangeListener(this);
        quadrantEt.setOnClickListener(this);
        quadrantEt.setOnFocusChangeListener(this);
        fromDateEt.setOnClickListener(this);
        fromDateEt.setOnFocusChangeListener(this);
        fromTimeEt.setOnClickListener(this);
        fromTimeEt.setOnFocusChangeListener(this);
        saveBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tcAct_label_et:
                showListDialog(view);
                break;
            case R.id.tcAct_role_et:
                showListDialog(view);
                break;
            case R.id.tcAct_quadrant_et:
                showListDialog(view);
                break;
            case R.id.tcAct_begin_date_et:
                showDateDialog();
                break;
            case R.id.tcAct_begin_time_et:
                showTimeDialog();
                break;
            case R.id.tcAct_save_bt:
                save();
                break;
        }
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        switch (view.getId()) {
            case R.id.tcAct_label_et:
                if(hasFocus) {
                    showListDialog(view);
                }
                break;
            case R.id.tcAct_role_et:
                if(hasFocus) {
                    showListDialog(view);
                }
                break;
            case R.id.tcAct_quadrant_et:
                if(hasFocus) {
                    showListDialog(view);
                }
                break;
            case R.id.tcAct_begin_date_et:
                if(hasFocus) {
                    showDateDialog();
                }
                break;
            case R.id.tcAct_begin_time_et:
                if(hasFocus) {
                    showTimeDialog();
                }
                break;
        }
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
                new MaterialDialog.Builder(InputErrorActivity.this)
                        .title("Input Error")
                        .content("输入错误，由TextInputLayout显示。但发现输入有误，EditText会变成红色而且显示错误信息。")
                        .positiveText("agree")
                        .negativeText("disagree")
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showListDialog(final View editText) {
        new MaterialDialog.Builder(this)
                .title("选择")
                .items(new String[] {"工作", "生活", "学习", "旅行"})
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        /**
                         * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                         * returning false here won't allow the newly selected radio button to actually be selected.
                         **/
                        ((EditText)editText).setText(text);
                        return true;
                    }
                })
                .positiveText("确定")
                .show();
    }

    public void showDateDialog() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    public void showTimeDialog() {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND), false);
        tpd.show(getFragmentManager(), "Timepickerdialog");
        //calendar.set(year, monthOfYear, dayOfMonth);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        fromDateEt.setText(DateUtil.toString(calendar.getTime(), "yyyy/MM/dd"));
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String timeStr = (hourOfDay < 10 ? "0"+hourOfDay : hourOfDay) + ":" + (minute < 10 ? "0"+minute : minute) + ":" + (second < 10 ? "0"+second : second);
        fromTimeEt.setText(timeStr);
    }

    public void save() {
        String name = titleEt.getText().toString();
        String desc = descEt.getText().toString();
        String label = labelEt.getText().toString();
        String role = roleEt.getText().toString();
        String quadrant = quadrantEt.getText().toString();
        String fromDate = fromDateEt.getText().toString();
        String fromTime = fromTimeEt.getText().toString();

        if(StringUtil.isEmpty(name)) {
            titleTi.setErrorEnabled(true);
            titleTi.setError("You need to enter a title");
        }else {
            titleTi.setErrorEnabled(false);
            titleTi.setError(null);
        }

        if(StringUtil.isEmpty(desc)) {
            descTi.setErrorEnabled(true);
            descTi.setError("You need to enter a desc");
        }else {
            descTi.setErrorEnabled(false);
            descTi.setError(null);
        }
        if(StringUtil.isEmpty(label)) {
            labelTi.setErrorEnabled(true);
            labelTi.setError("You need to enter a label");
        }else {
            labelTi.setErrorEnabled(false);
            labelTi.setError(null);
        }
        if(StringUtil.isEmpty(role)) {
            roleTi.setErrorEnabled(true);
            roleTi.setError("You need to enter a role");
        }else {
            roleTi.setErrorEnabled(false);
            roleTi.setError(null);
        }
        if(StringUtil.isEmpty(quadrant)) {
            quadrantTi.setErrorEnabled(true);
            quadrantTi.setError("You need to enter a quadrant");
        }else {
            quadrantTi.setErrorEnabled(false);
            quadrantTi.setError(null);
        }

        if(StringUtil.isEmpty(fromDate)) {
            fromDateTi.setErrorEnabled(true);
            fromDateTi.setError("You need to enter a fromDate");
        }else {
            fromDateTi.setErrorEnabled(false);
            fromDateTi.setError(null);
        }
        if(StringUtil.isEmpty(fromTime)) {
            fromTimeTi.setErrorEnabled(true);
            fromTimeTi.setError("You need to enter a fromTime");
        }else {
            fromTimeTi.setErrorEnabled(false);
            fromTimeTi.setError(null);
        }

    }
}
