package com.example.customTool;

import com.example.sever.DataBaseTool;

import android.content.ContentValues;
import android.database.Cursor;

public class Table_HistoryTool {
	public static void collectMistakes(int a[][]){
		ContentValues values=new ContentValues();
		DataBaseTool tool=new DataBaseTool();
		Cursor cursor=tool.db.rawQuery("select * from History", null);
		System.out.println("**************"+String.valueOf(cursor.getCount()));
		int mark=0;
		for(int i=0;i<a.length;i++){
			if(cursor.getCount()>0){//表示存在数据
				
				for(int j=0;j<cursor.getCount();j++){
					cursor.moveToPosition(j);
					
					if(cursor.getInt(cursor.getColumnIndex("QuestionID"))==a[i][0]){
						values.put("CorrectNum", a[i][1]+cursor.getInt(cursor.getColumnIndex("CorrectNum")));
						values.put("WrongNum", a[i][2]+cursor.getInt(cursor.getColumnIndex("WrongNum")));
						tool.upDate("History", values, "QuestionID", String .valueOf(cursor.getInt(cursor.getColumnIndex("QuestionID"))));
						values.clear();
						break;
					}
					else{
						mark++;
					}
				}
				if(mark>cursor.getCount()){
					values.put("QuestionID", a[i][0]);
					values.put("CorrectNum", a[i][1]);
					values.put("WrongNum", a[i][2]);
					tool.addItem("History", values);
					values.clear();
				}
			}else{//表示表为空
				values.put("QuestionID", a[i][0]);
				values.put("CorrectNum", a[i][1]);
				values.put("WrongNum", a[i][2]);
				tool.addItem("History", values);
				values.clear();
			}	
		}
	}

}
