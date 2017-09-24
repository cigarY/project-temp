package com.example.answerSys;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.Dao.QuestionDao;
import com.example.ItemBean.QuestionBean;
import com.example.customTool.DataBaseHelper;
import com.example.customTool.NetTool;
import com.example.customTool.ProgressAdapter;
import com.example.sever.DataBaseTool;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;

public class Main extends Activity implements OnClickListener{
	StringBuilder buffer=new StringBuilder();
	public static String str;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);
		
		DataBaseHelper h=new DataBaseHelper(this);
		try {
			h.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Button btn1=(Button) findViewById(R.id.button1);
		Button btn2=(Button) findViewById(R.id.button2);
		Button btn3=(Button) findViewById(R.id.button3);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.button1:{
			str="select * from History,QuestionBank where WrongNum>0 and QuestionID=QB_ID";
			Intent intent=new Intent(Main.this, Test.class);
			startActivity(intent);
//			DataBaseTool t=new DataBaseTool();
////			t.deleteItem("History");
//			Cursor cursor=t.db.rawQuery(str, null);
//			if(cursor.getCount()>0){
//				for(int i=0;i<cursor.getCount();i++){
//					cursor.moveToPosition(i);
//					System.out.println("题号"+cursor.getInt(cursor.getColumnIndex("QuestionID")));
//					System.out.println("错误"+cursor.getInt(cursor.getColumnIndex("WrongNum")));
//					System.out.println("正确"+cursor.getInt(cursor.getColumnIndex("CorrectNum")));
//					System.out.println("****************************************************");
//				}
//			}
		}
		break;
		case R.id.button2:{
			new Thread(){
				public void run(){
					try {
						buffer.append("select * from QuestionBank where QB_ID in (");
						JSONArray arr=NetTool.downItem();
						for(int i=0;i<arr.length();i++){
							JSONObject obj=arr.getJSONObject(i);
							buffer.append(obj.getInt("question_id"));
							buffer.append(",");
							Log.e("question_id", String.valueOf(obj.getInt("question_id")));
						}
						buffer.append(")");
						buffer.delete(buffer.length()-2, buffer.length()-1);
						str=buffer.toString();
						System.out.println("Main"+"       "+str);
						Intent intent=new Intent(Main.this, Test.class);
						startActivity(intent);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
		}
		break;
		case R.id.button3:{
//			str="select * from QuestionBank ORDER BY RANDOM() limit 5";
			str="select * from QuestionBank where QB_ID<=3";
			Intent intent=new Intent(Main.this, Test.class);
			startActivity(intent);
		}
		break;
	}

	}
}
