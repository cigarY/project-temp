package com.example.customTool;

import com.example.answerSys.Main;
import com.example.dialog.Dialog_single;
import com.example.sever.DataBaseTool;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;

public class ShowDialogSingle {

	public void showDialog(Context context,String title,String message,String btn_text){
		final Dialog_single single=new Dialog_single(context, title, message, btn_text);
//		single.main_tv2.setVisibility(View.GONE);
		single.show();
		single.setCallBack(new Dialog_single.MyCallBack() {
			
			@Override
			public void ok() {
				// TODO Auto-generated method stub
				single.dismiss();
			}
		});
	}
}
