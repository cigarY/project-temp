package com.heven.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream类解析 {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("1","1","2","2");
		//generate必须使用limit限制stream的大小
		Stream<Double> stream2 = Stream.generate(() ->Math.random()*10).limit(20);
//		stream2.forEach(o->System.out.println(Math.floor(o)));
//		Stream.iterate(2,item->item+2).limit(10).findFirst();
//		long count = stream.distinct().count();
//		System.out.println(count);
		
		Integer[] a=  new Integer[]{1,1,null,2,3,4,null,5,6,7,8,9,10};
		List<Integer> nums = Arrays.asList(a);
//		System.out.println("sum is:"+nums.stream().filter(num -> num != null).
//		            distinct().mapToInt(num -> num * 2).
//		            peek(System.out::println).skip(2).limit(4).sum());

		    List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
		            collect(() -> new ArrayList<Integer>(),
		                    (list, item) -> list.add(item),
		                    (list1, list2) -> list1.addAll(list2));
		    System.out.println(numsWithoutNull);
		    numsWithoutNull.stream().max((o1,o2) ->o1.compareTo(o2)).ifPresent(System.out::print);
//		    Integer total = numsWithoutNull.stream().filter(x ->x!=null).distinct().reduce((sum,foot)->sum+foot).get();
	}
}
