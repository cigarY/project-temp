package com.heven.poj;

public class Test {
	static int[] a = {1,3,1,2,0,4,6,8,5,7,9,5,8,10,12,11,13,16,15};
//	static boolean flag;
	public static void main(String[] args) {
		sort(a);
		for(int i:a)
			System.out.printf("%d%s",i," ");
	}
	private static void sort(int[] a) {
		sort(a,0,a.length-1);
	}
	private static void sort(int[] a, int lo, int hi) {
		if(lo<hi){
			int i= lo, j = hi , temp = a[lo];
			while(i<j){
				while(i<j&&a[j]>temp)
					j--;
				if(i<j)
					a[i++] = a[j];
				while(i<j&&a[i]<temp)
					i++;
				if(i<j)
					a[j--] = a[i];
			}
			a[i] = temp;
			sort(a, lo, i-1);
			sort(a,i+1,hi);
		}
	}
}
