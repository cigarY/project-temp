package com.heven.ar.dp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class 钢管切割 {

	static int[] p = {0,1,5,8,9,10,17,17,20,24,30};
	static int[] a = {2,3,4,61,3,4,5,3,58,5,4,8,2,5,5,5,8,9,3,1,8,2,9,3,8,2,9,2,9,2,93,9,7,48,48,96,5,8,1,6,6,45};
	public static void main(String[] args) throws IOException {
		/*int len = a.length;
		quick_sort(a, 0, len-1);*/
		
		breakhere:	for(int i=0;i<10;i++){
						for(int j=0;i<3;j++){
							System.out.println("此时i="+i+",j="+j);
							if(j==1){
								
								break breakhere;
							}
						}
					}
		
		
	}
	
	public static void quick_sort(int[] a,int lo,int hi){
		if(lo<hi){
			int i = lo,j = hi,compare = a[lo];
			while(i<j){
				while(i<j&&a[j]>compare)
					j--;
				if(i<j)
					a[i++] = a[j];
				
				while(i<j&&a[i]<compare)
					i++;
				if(i<j)
					a[j--] = a[i];
			}
			a[i] = compare;
			quick_sort(a,lo,i-1);
			quick_sort(a, i+1, hi);
		}
	}



}
