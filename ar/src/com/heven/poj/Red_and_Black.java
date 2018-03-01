package com.heven.poj;

import java.util.Scanner;

/**
 * 红黑砖块
 * @author thundersoft
 *
 */
public class Red_and_Black {

	static int n = 0, m = 0;
	static String[] point = new String[20];
	static boolean[][] v= new boolean[20][20];
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=0;i<m;i++){
			point[i] = sc.next();
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(point[i].charAt(j)=='@'){
					System.out.println(dfs(i,j));
				}
			}
		}
		sc.close();
	}
	static int dfs(int i, int j) {
		if(i<0||j<0||i>=m||j>=n)
			return 0;
		if(point[i].charAt(j)=='#')
			return 0;
		if(v[i][j])
			return 0;
		
		v[i][j] = true;
		return 1+dfs(i+1, j)+dfs(i, j+1)+dfs(i-1, j)+ dfs(i, j-1);
	}
}
