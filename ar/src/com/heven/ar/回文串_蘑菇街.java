package com.heven.ar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;

public class 回文串_蘑菇街 {

	public static void main(String[] args) {
//		Scanner sc =new Scanner(System.in);
//		String s = sc.next();
//		int[] map = new int[26];
//		char[] a=  s.toCharArray();
//		int len = a.length;
//		int i=0;
//		for(;i<len;i++){
//			map[a[i]-'a']+=1;
//		}
//		int temp = 0;
//		for(i=0;i<len;i++){
//			if(map[i]%2==1)
//				temp++;
//		}
		Integer[] x=  new Integer[]{12,2,3};
		List<Integer> list = new ArrayList<Integer>(10);
		Integer[] array = list.toArray(x);
		Spliterator<Integer> spliterator = list.spliterator();
		
//		String result = temp>1?"NO":"YES";
		System.out.println();
	}
}
