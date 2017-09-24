package com.example.customTool;

import java.util.List;

import com.example.ItemBean.QuestionBean;

public class Judgement {

	public static int[][] judge(List<QuestionBean> list,int[] vessel){
		int saveResult[][]=new int[list.size()][3];
		for(int i=0;i<list.size();i++){
			saveResult[i][0]=list.get(i).getQB_ID();
			if(list.get(i).getUserAnswer().equals(list.get(i).getAnswer())){
				vessel[0]++;
				saveResult[i][1]++;
			}else{
				vessel[1]++;
				saveResult[i][2]++;
			}
		}
		return saveResult;
	}
}
