package com.look.model;

/*
 * 随机生成相应的题目数存入数组中
 */
public class SubjectNum {
	
	public SubjectNum(){
		
	}
	
	//获取随机题目
	public int[] getRandom(int count, int sumNum) {
		int[] arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = (int) (Math.random() * sumNum+1);
			for (int j = 0; j < i + 1; j++) {
				if ((i != j) && arr[i] == arr[j])
					arr[i] = (int) (Math.random() * sumNum+1);
			}
		}
		return arr;
	}

	//获取对应的题目数组
	public int[] getTestNum(int type, int sumNum) {
		int count = 0;
		int[] getArr = null;
		if (type == 1) {
			count = 100;
			getArr = new int[count];
			getArr = getRandom(count, sumNum);

		} else if (type == 4) {
			count = 50;
			getArr = new int[count];
			getArr = getRandom(count, sumNum);
		}
		return getArr;
	}

}
