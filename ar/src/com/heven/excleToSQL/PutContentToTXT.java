package com.heven.excleToSQL;

import java.io.File;
import java.io.PrintWriter;

public class PutContentToTXT {

	public static void pubContent(File file,StringBuffer content){
//		File fp=new File("D:\\soft\\workspace_heven_ar\\res.txt");
//		File fp=new File(fileName);
		try {
		     PrintWriter pfp= new PrintWriter(file);
		     pfp.print(content);
		     pfp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
