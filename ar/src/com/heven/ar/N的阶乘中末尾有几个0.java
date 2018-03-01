package com.heven.ar;

/**
 * 
 * @author thundersoft
 *
 */
public class N的阶乘中末尾有几个0 {

	public static void main(String[] args) {
		System.out.println(count(1000));
	}
	
	public static int count(int n){
		int sum = 0;
		while(n!=0){
			sum+=n/5;
			n/=5;
		}
		return sum;
	}
}
