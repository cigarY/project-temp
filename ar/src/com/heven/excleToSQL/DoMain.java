package com.heven.excleToSQL;

import java.io.File;

public class DoMain {

	public static void main(String[] args) {
		StringBuffer sb  = getContentFromTXT.getContent("D:\\soft\\workspace_heven_ar\\test.txt");
		File file = new File("D:\\soft\\workspace_heven_ar\\res.txt");
		PutContentToTXT.pubContent(file, sb);
		System.out.println("操作完成");
	}
}
