package com.heven.ar;

public class 字符串移位 {

	static int count = 0;

	public static void main(String[] args){
		String s = "abc#d";
		String s1 = "sadjfkadsl##";
//		String result = getChangedString(s1);
//		doubleFor(s1);
//		System.out.println(result);
		System.out.println(Integer.MAX_VALUE);
	}
	
	public static String getChangedString(String s){
		if(s.length()<=1||s==null) return s;
		char[] a = s.toCharArray();
		int len = a.length;
		int begin = 0;
		int end = len -1;
		char temp;
		while(begin<end){
			while(a[begin]=='#'){
				begin++;
			}
			while(a[end]!='#'){
				end--;
			}
			if(begin<end){
				temp = a[begin];
				a[begin] = a[end];
				a[end] = temp;
			}
			begin++;
			end--;
		}
		StringBuilder sb  = new StringBuilder();
		for(int i =0 ;i<len;i++){
			sb.append(a[i]);
		}
		return sb.toString();
	}
	
	public static void doubleFor(String s){
		if(s==null||s.length()<=1) {
			System.out.println(s);
			return;
		}
		int len = s.length();
		int i =0;
		for(;i<len;i++){
			if(s.charAt(i)=='#')
				System.out.print("#");
		}
		for(i=0;i<len;i++){
			if(s.charAt(i)!='#')
				System.out.print(s.charAt(i));
		}
		return;
	}
}
