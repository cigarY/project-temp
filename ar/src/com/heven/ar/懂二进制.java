package com.heven.ar;

import java.util.Scanner;

public class 懂二进制 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int result = sub(num1,num2);
		System.out.println(result);
	}
	
	public static int sub(int a,int b){
		a = a^b;
		int res = 0;
		while(a!=0){
			if(a%2==1)
				res+=1;
			a/=2;
		}
		return res;
	}
}
