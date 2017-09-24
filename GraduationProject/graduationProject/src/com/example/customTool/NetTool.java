package com.example.customTool;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetTool {

	/**
	 * 向服务器请求数据
	 * @return
	 */
	public static JSONArray downItem(){
		try {
			HttpClient client=new DefaultHttpClient();//创建连接
			//连接超时
			HttpConnectionParams.setConnectionTimeout(client.getParams(), 5000);
			//请求超时
			HttpConnectionParams.setSoTimeout(client.getParams(), 5000);
			
//			HttpGet get=new HttpGet("http://172.17.26.28:8080/appServers/ItemServlet");
//			HttpGet get=new HttpGet("http://192.168.2.73:8080/servers/DownItemServelt");
			HttpGet get=new HttpGet(GetHttpUrl.getUrl().get("down"));
			
			HttpResponse execute=client.execute(get);
			System.out.println("**********************"+execute.getStatusLine().getStatusCode());
			if(execute.getStatusLine().getStatusCode()==200){
				//请求响应都成功
				HttpEntity entit=execute.getEntity();
				String result=EntityUtils.toString(entit, "utf-8");
				System.out.println("*********************"+result.toString());
				//创建jsonarray对象
				JSONArray arr=new JSONArray(result);	
				return arr;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 向服务器发送数据
	 */
	public static String upItem(JSONObject json){
		//获取httpclient对象
		HttpClient client=new DefaultHttpClient();
		//连接超时
		HttpConnectionParams.setConnectionTimeout(client.getParams(), 5000);
		//请求超时
		HttpConnectionParams.setSoTimeout(client.getParams(), 5000);
		//设置访问地址
//		String url="http://192.168.2.73:8080/servers/UpItemServelt";
		String url=GetHttpUrl.getUrl().get("up");
		//post请求
		HttpPost post=new HttpPost(url);
		post.setHeader("Content-Type",  
				"application/x-www-form-urlencoded; charset=utf-8");
		
		//组装提交的数据实体
		try {
			List<NameValuePair> param=new ArrayList<NameValuePair>();
			String content=String .valueOf(json);
			param.add(new BasicNameValuePair("param", content));
			post.setEntity(new UrlEncodedFormEntity(param, "utf-8"));
			
			//接收返回结果
			HttpResponse res=client.execute(post);
			int code=res.getStatusLine().getStatusCode();
			System.out.println("*******************"+code);
			if(code==200){
				InputStream is=res.getEntity().getContent();
				String result=StreamTools.readInputStream(is);
				return result;
			}else{
				return null;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
