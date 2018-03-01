package com.heven.ar.array;

import java.util.Scanner;

public class 连续最大子数组 {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[] a= {1,-2,3,10,-4,7,2,-5};
		int len = a.length;
		int[] dp = new int[len];
		int max = dp[0];
		int begin = 0;
		int end = 0;
		for(int i=1;i<len;i++){
			dp[i] = Math.max(dp[i-1]+a[i], a[i]);
			if(dp[i]>max){
				begin = end;
				end = i;
				max= dp[i];
			}
		}
		System.out.println(max);
		System.out.println(begin+","+end);
	}
}
