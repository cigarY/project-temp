package com.heven.ar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 幸运数 {

	static int[] a = {3,9,6,8,-10,7,-11,19,30,12,23,5};
	static boolean flag;
	public static void main(String[] args) {
		flag = true;
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		while(sc.hasNextInt())
			list.add(sc.nextInt());
		int i=0 ,k = list.get(list.size()-1),len =a.length;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,new Mycomparator(flag));
		while(i<len-1){
			int temp = list.get(i);
			if(pq.size()>=k){
				if(flag){
					if(pq.element()<temp){//最大的前k个数
						pq.poll();
						pq.add(temp);
					}
				}else{
					if(pq.element()>temp){//最小的前k个数
						pq.poll();
						pq.add(temp);
					}
				}
			}else
				pq.add(temp);
			i++;
		}
		int[] res= new int[list.get(list.size()-1)];
		for(i=0;i<res.length;i++){
			res[i] = pq.poll();
		}
		Arrays.sort(res);
		for(i=0;i<res.length;i++){
			System.out.printf("%d%s",res[i],i!=res.length-1?" ":"\n");
		}
		sc.close();
	}
}
class Mycomparator implements Comparator<Integer>{
	private boolean flag = false;
	public Mycomparator(){}
	public Mycomparator(boolean flag){
		this.flag = flag;
	}
	public int compare(Integer x, Integer y) {
		return  flag?x.compareTo(y):y.compareTo(x);
	}
}
