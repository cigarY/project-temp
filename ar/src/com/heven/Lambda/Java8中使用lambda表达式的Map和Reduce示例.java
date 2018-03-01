package com.heven.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8中使用lambda表达式的Map和Reduce示例 {

	public static void main(String[] args) {
		// 使用lambda表达式的 reduce方法计算和
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		Double total = costBeforeTax.stream().map(cost -> cost + .12*cost).reduce((sum,cost)->sum+cost).get();
		System.out.println(total);
		//使用lambda表达式的map+forEach
		costBeforeTax.stream().map(cost -> cost + .12*cost).forEach(System.out::print);
	}
	
	public static void test(){
		List<String> list = new ArrayList<String>();
	}
}
