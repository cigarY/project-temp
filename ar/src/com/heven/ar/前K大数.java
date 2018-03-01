package com.heven.ar;

import java.util.Set;
import java.util.TreeSet;

public class 前K大数 {

	public static void main(String[] args) {
		int[] a = new int[]{9,2,3,4,5,7,8,9,3,4,5,10,11,2,4,13,16,4,20};
		Set<Integer> s = getNumberBiggerThanK(a,2);
		System.out.println();
	}
	
	public static Set<Integer> getNumberBiggerThanK(int[] a,int k){
		Set<Integer> set= new TreeSet<Integer>();
		int len = a.length;
		if(a.length==0||len<k)
			return set;
		int i = 0;
		for(;i<len;i++){
			if(i<k){
				set.add(a[i]);
				continue;
			}
			int temp = set.iterator().next().intValue();
			if(temp<a[i]){
				if(!set.contains(a[i])){
					set.remove(temp);
					set.add(a[i]);
				}
			}
		}
		return set;
	}
}
