package com.example.Dao;

import java.util.ArrayList;
import java.util.List;

import com.example.ItemBean.QuestionBean;
import com.example.answerSys.Main;
import com.example.sever.DataBaseTool;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class QuestionDao {
	private Cursor cursor;
	DataBaseTool tool=new DataBaseTool();

	public QuestionDao() {
//		cursor=tool.db.rawQuery("select * from QuestionBank ORDER BY RANDOM() limit 5", null);//获取数据库连接
//		cursor=tool.db.rawQuery("select * from QuestionBank where QB_ID in (5,10,19,20,25)", null);//获取数据库连接
		System.out.println("QuestionDao"+"       "+Main.str);
		cursor=tool.db.rawQuery(Main.str, null);
		System.out.println(String.valueOf(cursor.getCount()));
	}
	
	public List<QuestionBean> getItems(){
		List<QuestionBean> list=new ArrayList<QuestionBean>();
		if(cursor.getCount()>0){
			for(int i=0;i<cursor.getCount();i++){
				cursor.moveToPosition(i);
				QuestionBean q=new QuestionBean();
				q.setQB_ID(cursor.getInt(cursor.getColumnIndex("QB_ID")));
				q.setCategorID(cursor.getInt(cursor.getColumnIndex("CategorID")));
				q.setChapterNum(cursor.getInt(cursor.getColumnIndex("ChapterNum")));
				q.setQuestion(cursor.getString(cursor.getColumnIndex("Question")));
				q.setQuestionType(cursor.getInt(cursor.getColumnIndex("QuestionType")));
				q.setChoiceNum(cursor.getInt(cursor.getColumnIndex("ChoiceNum")));
				q.setChoiceStr(cursor.getString(cursor.getColumnIndex("ChoiceStr")));
				q.setAnswer(cursor.getString(cursor.getColumnIndex("Answer")));
				q.setExplaination(cursor.getString(cursor.getColumnIndex("Explaination")));
				q.setSourceID(cursor.getInt(cursor.getColumnIndex("SourceID")));
				q.setUserAnswer(null);
				list.add(q);
			}
		}
		return list;
	}

}
