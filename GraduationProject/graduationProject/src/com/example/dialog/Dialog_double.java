package com.example.dialog;

import com.example.answerSys.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Dialog_double extends Dialog implements android.view.View.OnClickListener{

	public interface MyCallBack {
		void ok();
		void cancle();
	}

	private String title,message,btn_ok_text,btn_cancle_text;
	private MyCallBack myCallBack;
	private TextView title_tv,main_tv;
	private Button btn_ok,btn_cancle;

	public Dialog_double(Context context,String title,String message,String btn_ok_text,String btn_cancle_text) {
		super(context,R.style.dialog_custom);
		this.title=title;
		this.message=message;
		this.btn_ok_text=btn_ok_text;
		this.btn_cancle_text=btn_cancle_text;
		// TODO Auto-generated constructor stub
	}
	
	public void setCallBack(MyCallBack myCallBack){
		this.myCallBack=myCallBack;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_double);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		title_tv=(TextView) findViewById(R.id.title_textview_double);
		main_tv=(TextView) findViewById(R.id.mainText_double);
		btn_ok=(Button) findViewById(R.id.btn_ok_double);
		btn_cancle=(Button) findViewById(R.id.btn_cancle_double);
		btn_ok.setOnClickListener(this);
		btn_cancle.setOnClickListener(this);
		title_tv.setText(title);
		main_tv.setText(message);
		btn_ok.setText(btn_ok_text);
		btn_cancle.setText(btn_cancle_text);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btn_ok_double:
			myCallBack.ok();
			break;
		case R.id.btn_cancle_double:
			myCallBack.cancle();
			break;
		}
	}
	
	

}
