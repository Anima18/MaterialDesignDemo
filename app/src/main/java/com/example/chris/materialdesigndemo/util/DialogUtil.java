package com.example.chris.materialdesigndemo.util;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.chris.materialdesigndemo.R;

/**
 * Created by Chris on 2015/9/2.
 */
public class DialogUtil {
	public static void showConfirmDialog(final Context context, String title, String message, 
			final ButtonOnclickCallBack positiveCallBack, final ButtonOnclickCallBack neutralCallBack, 
			final ButtonOnclickCallBack cancelCallBack) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		//builder.setIcon(R.mipmap.ic_launcher);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton(context.getResources().getString(R.string.dialog_button_positive), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				positiveCallBack.callBack();
			}
		});
		builder.setNegativeButton(context.getResources().getString(R.string.dialog_button_negative), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				neutralCallBack.callBack();
			}
		});
		builder.setOnCancelListener(new DialogInterface.OnCancelListener(){
		    @Override
		    public void onCancel(DialogInterface dialog){
		    	cancelCallBack.callBack();
		    }
		});
		builder.setCancelable(false);
		builder.show();
	}
	
	public static void showAlertDialog(Context context, String title, String message,
			final ButtonOnclickCallBack positiveCallBack, final ButtonOnclickCallBack cancelCallBack) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		//builder.setIcon(R.mipmap.ic_launcher);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton(context.getResources().getString(R.string.dialog_button_positive), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				positiveCallBack.callBack();
			}
		});
		builder.setNegativeButton(context.getResources().getString(R.string.dialog_button_negative), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				cancelCallBack.callBack();
			}
		});
		builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
			@Override
			public void onCancel(DialogInterface dialog) {
				cancelCallBack.callBack();
		    }
		});
		builder.setCancelable(false);
		builder.show();
	}


}
