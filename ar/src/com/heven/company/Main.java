package com.heven.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
圆周上两点间的距离
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 30720KB；其他语言 555008KB
题目描述：
定义圆周上两点的距离s为这两点之间的劣弧对应的圆心角度数(0<=s<=180)，
现输入圆周上的n个点（n>=2），以角度a表示其位置(0<=a<360)，
输入按a从小到大排序。求最远的一对点之间的距离。

输入
第一行为点个数n，后跟n行，每行一个双精度浮点数，
表示点的角度（小数点后保留8位），例如输入样例中为4个点的输入：
输出
输出最远的一对点之间的距离（双精度浮点数，小数点后保留8位）和'\n'换行符。例如输入样例中，
10.00000000与183.00000000两个点之间的距离为173.00000000，大于10.00000000与198.0000000之间的距离172.00000000，
所以应输出：
173.00000000

样例输入
2
0.0000000
3.0000000
358.00000000
359.00000000
样例输出
173.00000000
 * @author thundersoft
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
//		int n =sc.nextInt();
		double min = Double.MIN_VALUE;
		double max = Double.MAX_VALUE;
		double now = 0;
		double[] a = new double[n];
		for(int i=0;i<n;i++){
			a[i]  = Double.parseDouble(reader.readLine());
//			a[i] = sc.nextDouble();
		}
		Arrays.sort(a);
		int begin = 0,end = n-1;
		int cmp = 180;
		double res =a[end]-a[begin]>cmp?2*cmp-a[end]+a[begin]:a[end]-a[begin];
		while(begin<end){
			double temp = a[end]-a[begin]>cmp?2*cmp-a[end]+a[begin]:a[end]-a[begin];//当前的大小
			if(temp>=res){
				res = temp;
			}
			if(begin+1<end-1&&a[begin+1]-a[begin]>a[end]-a[end-1]){//右指针--
				end--;
			}else{//左指针++
				begin++;
			}
		}
		System.out.printf("%.8f",res);
	}
}


