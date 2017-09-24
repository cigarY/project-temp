package com.example.customTool;

import com.example.dialog.Dialog_double;

import android.content.Context;

public class ShowDialogDouble {
	public void showDialog(Context context,String title,String message,String btn_ok_text,String btn_cancle_text){
		final Dialog_double doub=new Dialog_double(context, title, message, btn_ok_text, btn_cancle_text);
		doub.show();
		doub.setCallBack(new Dialog_double.MyCallBack() {
			
			@Override
			public void ok() {
				// TODO Auto-generated method stub
				FinishActivity.getInstance().exit();
			}
			
			@Override
			public void cancle() {
				// TODO Auto-generated method stub
				doub.dismiss();
			}
		});
	}

}
