package com.example.customTool;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class GetHttpUrl {
	public static final String PROPERTY_FILE="httpPath.properties";
	
	/**
	 * 获取配置文件的内容
	 */
	public static HashMap<String, String> getUrl(){
		HashMap<String, String> url=new HashMap<String, String>();
		Properties prop=new Properties();
		try {
			prop.load(GetHttpUrl.class.getClassLoader().getResourceAsStream(PROPERTY_FILE));
			url.put("down", prop.getProperty("downItemUrl"));
			url.put("up", prop.getProperty("upItemUrl"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
}
