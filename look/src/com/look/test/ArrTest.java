package com.look.test;

import com.look.model.SubjectNum;

public class ArrTest {
	public static void main(String arg[]){
		SubjectNum tn = new SubjectNum();
		int[] nums = tn.getTestNum(4, 200);
		for(int num:nums){
			System.out.println(num+"\t");
		}
	}
}
