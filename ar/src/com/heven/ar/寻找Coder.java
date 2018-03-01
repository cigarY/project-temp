package com.heven.ar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class 寻找Coder {

	public static void main(String[] args) {
		String[] s = {"i am a coder","Coder Coder","Code"};
		String[] strings = findCoder(s, s.length);
		Stream.of(strings).forEach(System.out::print);
	}
	
	public static String[] findCoder(String[] a, int n) {
		Map<String,Integer> map = new LinkedHashMap<String,Integer>();
		int len = 0;
		for(int i = 0;i<n;i++){
			len = a[i].length();
			if(len>5){
				String case1 = a[i].toUpperCase();
				for(int j=len-6;j<len-4;j++){
					if(case1.charAt(j)=='C'){
						if("CODER".equals(case1.substring(j, j+5))){
							map.put(a[i], map.get(a[i])+1);
							break;
						}
					}
				}
			}
		}
        return new String[]{""};
    }
}

