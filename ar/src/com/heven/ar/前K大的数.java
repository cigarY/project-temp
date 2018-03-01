package com.heven.ar;

import java.util.Set;
import java.util.TreeSet;

public class 前K大的数 {
	public static void main(String[] args) {
		Set<Integer> set=  new TreeSet<Integer>();
		int[] a = {2,3,4,61,3,4,5,3,58,5,4,8,2,5,5,5,8,9,3,1,8,2,
				   9,3,8,2,9,2,9,2,93,9,7,48,48,96,5,8,1,6,6,45};
		for(int x :a){
			if(set.size()<6){
				set.add(x);
			}else{
				if(!set.contains(x)){
					if(x>set.iterator().next().intValue()){
						set.remove(set.iterator().next().intValue());
						set.add(x);
					}
				}else{
					continue;
				}
			}
		}
		System.out.println();
	}
}
