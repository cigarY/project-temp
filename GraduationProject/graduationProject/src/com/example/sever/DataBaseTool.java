package com.example.sever;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseTool {
	public  SQLiteDatabase db;
//	private static String sql;
	
//	public String getSql() {
//		return sql;
//	}
//
//
//	public void setSql(String sql) {
//		this.sql = sql;
//	}


	public DataBaseTool(){
		db=SQLiteDatabase.openDatabase("/data/data/com.example.answerSys/databases/QuestionBase.db", null, SQLiteDatabase.OPEN_READWRITE);
	}
	
	
	/*
	 * 添加数据
	 */
	public void addItem(String tableName,ContentValues values){
		db.insert(tableName, null, values);
	}
	
	/*
	 *删除数据 
	 */
	public void deleteItem(String tableName){
		db.execSQL("delete from"+" "+tableName);
	}
	/*
	 * 修改数据
	 */
	public void upDate(String tableName,ContentValues value,String condition,String cdtValue){
		String sql;
		db.update(tableName, value, condition+"=?", new String[]{cdtValue});
		//db.execSQL("update"+" "+table+" "+"set"+" "+value+" "+"where"+" "+condition);
		//db.close();
	}

}
