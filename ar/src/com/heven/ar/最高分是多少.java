package com.heven.ar;

import java.util.Scanner;

public class 最高分是多少 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int total = sc.nextInt();
		int options = sc.nextInt();
		int[] a = new int[total];
		int i = 0;
		for(;i<total;i++){
			a[i] = sc.nextInt();
		}
		int t0 = 0 ;
		int t1 = 0;
		int max = 0;
		while(options-->0){
			String s = sc.next();
			t0 = sc.nextInt();
			t1  = sc.nextInt();
			if(s.equals("Q")){
				max = a[t0-1];
				for(int j= t0-1;j<t1;j++){
					if(max<a[j])
						max = a[j];
				}
				System.out.println(max);
			}else{
				a[t0-1] = t1;
			}
		}
	}
}
