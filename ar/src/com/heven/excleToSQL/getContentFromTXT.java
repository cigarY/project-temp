package com.heven.excleToSQL;

import java.io.BufferedReader;
import java.io.FileReader;

public class getContentFromTXT {

	public static StringBuffer getContent(String fileName){
		StringBuffer result = new StringBuffer();
		try{
            BufferedReader br = new BufferedReader
            		(new FileReader(fileName));
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+doFilterOfInfo(s));
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
		return result;
	}
	
	public static String doFilterOfInfo(String s){
		
		return "";
	}
}
