package com.heven.ar;

/**
 * 17/8/14
 * @author ThunderSoft
 *
 */
public class 快排_递归 {

	public static void main(String[] args) throws Exception {
//		int[] a = {2,3,4,61,3,4,5,3,58,5,4,8,2,5,5,5,8,9,3,1,8,2,9,3,8,2,9,2,9,2,93,9,7,48,48,96,5,8,1,6,6,45};
//		int[] a = {1,2,3,4,5,6};
		int[] a = {6,5,4,3,2,1};
		int[] x  = new int[1000000];
		for(int i=0;i<1000000;i++){
			Double value = Math.floor(Math.random()*1000);
			x[i] = value.intValue();
		}
		long xx = 0;
		System.out.println(xx = System.currentTimeMillis());
		s(a,0,a.length-1);
		System.out.println("花费时间"+(System.currentTimeMillis()-xx)+"毫秒");
		System.out.println();
	}

	private static void s(int[] a, int lo, int hi) {
		if(lo<hi){
			int i = lo , j= hi , x = a[lo];
			while(i<j){
				while(i<j&&a[j]>x)
					j--;
				if(i<j)
					a[i++]  = a[j];
				
				while(i<j && a[i]<x)
					i++;
				if(i<j)
					a[j--] = a[i];
			}
			a[i] = x;
			s(a, lo, i-1);
			s(a, i+1, hi);
		}
	}
	
}
