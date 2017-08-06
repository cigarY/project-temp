package com.look.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MySqlHelper {
   private Connection conn ;
   private ResultSet  rs;
   private PreparedStatement ps;
   /*
    * 获取连接
    * */
    public void getConnection(){
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/look?useUnicode=true&characterEncoding=UTF-8";
			String user ="root";
			String password="123456";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 
    /*关闭连接*/
    public void close(){
		try {
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(ps!=null)
				ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    /*
     * 查询功能
     * */
    public ResultSet executeQuery(String sql,Object...objects){
		this.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			if(objects!=null)
				for(int i=0;i<objects.length;i++){
					ps.setObject(i+1, objects[i]);
				}
			return ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
