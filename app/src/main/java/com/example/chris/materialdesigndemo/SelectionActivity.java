package com.example.chris.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Admin on 2016/8/7.
 */
public class SelectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        getSupportActionBar().setElevation(0);
    }

    public void submit(View view){
        StringBuffer sb = new StringBuffer();
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        sb.append("性别：");
        sb.append(radiovalue);
        sb.append("\n");

        AppCompatCheckBox readerCheckBox = (AppCompatCheckBox) findViewById(R.id.reader_checkBox);
        AppCompatCheckBox bosCheckBox = (AppCompatCheckBox) findViewById(R.id.bas_checkBox);
        AppCompatCheckBox runCheckBox = (AppCompatCheckBox) findViewById(R.id.run_checkBox);
        sb.append("爱好：");
        if (readerCheckBox.isChecked()) {
            sb.append(readerCheckBox.getText().toString());
            sb.append(",");
        }
        if (bosCheckBox.isChecked()) {
            sb.append(bosCheckBox.getText().toString());
            sb.append(",");
        }
        if (runCheckBox.isChecked()) {
            sb.append(runCheckBox.getText().toString());
            sb.append(",");
        }
        sb.append("\n");

        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.swichCompat);
        sb.append("是否是学生：");
        if (switchCompat.isChecked()) {
            sb.append(switchCompat.getTextOn());
        } else {
            sb.append(switchCompat.getTextOff());
        }
        sb.append("\n");

        Toast.makeText(SelectionActivity.this, sb.toString(), Toast.LENGTH_LONG).show();
    }
}
