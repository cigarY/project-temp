package com.heven.ar;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.WeakHashMap;

public class 有序数组找到只出现一次的数 {
	
	public static void main(String[] args) {
		int[] a =new int[]{1,1,2,3,3,4,4,5,5,6,6};
		int result =  getNumber(a,a.length-1);
		System.out.println(result);
	}

	private static int getNumber(int[] a ,int len) {
//		while(start<end){
//			int mid = start + (start+end)/2;
//			if(a[mid]==a[mid+1]){
//				end = a[mid]-1;
//			}else if(a[mid-1]==a[mid]){
//				start = a[mid];
//			}else{
//				return a[mid];
//			}
//		}
		int res = 0;
		int mid = len/2;
		while(len/2>0){
			mid = len/2;
			if(a[mid]==a[mid+1]){
				if((len-mid)>>1==1){
					//这边为偶数个
					mid = mid/2;
					len = mid+1;
				}
			}else if(a[mid]==a[mid-1]){
				len = mid;
				mid = len/2;
			}else{
				return a[mid];
			}
			
		}
		List<Integer> list = new ArrayList<Integer>();
//		WeakReference w = new WeakReference<List>(list);//弱引用
		Collections.synchronizedList(list);
//		SoftReference s = new SoftReference<List>(list);//软引用
		ReferenceQueue q = new ReferenceQueue();
		Reference s = new PhantomReference<List>(list, q);//虚引用
		return -1;
	}

}
