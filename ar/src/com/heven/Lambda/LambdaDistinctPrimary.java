package com.heven.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaDistinctPrimary extends Thread{

	public static void main(String[] args){
//		String[] strings = {"1","2","3","4"};
//		distinctPrimary(strings);
//		threadLambda(strings);
		String[] filters = {"Java", "Scala", "C++", "Haskell", "Lisp"};
		filterAndLambda(filters);
	}

	private static void threadLambda(String[] strings) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("老式调用线程");
			}
		}).start();
		
		new Thread(()->System.out.println("JDK8 new Lambda表达式")).start();
		List<String> s = Arrays.asList(strings);
		s.forEach(string->System.out.print(string+","));
		s.forEach(System.out::print);
	}
	
	public static void filterAndLambda(String... strings){
		List<String> s= Arrays.asList(strings);
//		filter(s, (str)->str.startsWith("j"));
//		filter(s, (str)->str.endsWith("a"));
//		System.out.println("Print language whose length greater than 4:");
//		filter(s, (str)->str.length()>4);
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		s.stream()//通过stream的filter过滤内容，其中可以使用不同方法进行选择过滤
		    .filter(startsWithJ.or(fourLetterLong).negate())
		    .forEach((n) -> System.out.print(n+","));
		System.out.println();
		s.stream()
	    .filter(startsWithJ.and(fourLetterLong))
	    .forEach((n) -> System.out.print(n));
	
	}
	
	public static void filter(List<String> names,Predicate<String> predicate){
		for(String name : names){
			if(predicate.test(name))
				System.out.println(name+" ");
		}
		names.stream().filter((name)->(predicate.test(name))).forEach(name->System.out.println(name));
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		names.stream()
		    .filter(startsWithJ.and(fourLetterLong))
		    .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
	}
	
	public static void distinctPrimary(String... numbers){
		List<String> list = Arrays.asList(numbers);
//		list.forEach(o->{System.out.println(o);});
		List<Integer> r = list.stream()
                .map(e -> new Integer(e))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinctPrimary result is: " + r);
	}
	
	
	
}
