package com.example.dialog;

import com.example.answerSys.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Dialog_single extends Dialog implements android.view.View.OnClickListener{
	public interface MyCallBack {
		void ok();
	}
	
	
	public TextView title_tv,main_tv1,main_tv2;
	private Button btn_ok;
	private String title,message1,message2,btn_text;
	private MyCallBack myCallBack;
	
	public Dialog_single(Context context,String title,String message1,String message2,String btn_text) {
		super(context,R.style.dialog_custom);
		this.title=title;
		this.message1=message1;
		this.message2=message2;
		this.btn_text=btn_text;
	}
	
	
	
	public Dialog_single(Context context, String title, String message1,String btn_text) {
		super(context,R.style.dialog_custom);
		this.title = title;
		this.message1 = message1;
		this.btn_text = btn_text;
	}



	public void setCallBack(MyCallBack myCallBack){
		this.myCallBack=myCallBack;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_single);
		initview();
	}
	private void initview() {
		// TODO Auto-generated method stub
		title_tv=(TextView) findViewById(R.id.title_textview_single);
		main_tv1=(TextView) findViewById(R.id.mainText_single1);
		main_tv2=(TextView) findViewById(R.id.mainText_single2);
		btn_ok=(Button) findViewById(R.id.btn_ok_single);
		btn_ok.setOnClickListener(this);
		title_tv.setText(title);
		main_tv1.setText(message1);
		main_tv2.setText(message2);
		btn_ok.setText(btn_text);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.btn_ok_single){
			myCallBack.ok();
		}
	}
	
	

}
