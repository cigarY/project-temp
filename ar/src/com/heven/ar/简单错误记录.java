package com.heven.ar;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。 处理:
1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，
错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
2.超过16个字符的文件名称，只记录文件的最后有效16个字符；
(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
3.输入的文件可能带路径，记录文件名称不能带路径

 * @author thundersoft
 *
 */
public class 简单错误记录 {

	public static void main(String[] args) {
	}
}
