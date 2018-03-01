package com.heven.ar.string;

/**
 * 给定遗传字符串，翻转字符串中的单词
 * @author thundersoft
 *
 */
public class 字符串翻转 {

	public static void main(String[] args) {
		String s = "who are you";
		System.out.println(res(s));
	}
	
	public static String res(String s){
		char[] a = s.toCharArray();
		//翻转整个字符串
		res(a,0,a.length-1);
		int begin=0;
		int i = 0;
		for(;i<a.length;i++){
			if(a[i]==' '){
				res(a, begin, i-1);
				begin =i+1;
			}
		}
		//翻转最后一个字符串
		res(a, begin, i-1);
		return new String(a);
	}
	private static void res(char[] a,int lo,int hi) {
		while(lo<hi){
			char temp = a[lo];
			a[lo++]  = a[hi];
			a[hi--] = temp;
		}
	}
}
