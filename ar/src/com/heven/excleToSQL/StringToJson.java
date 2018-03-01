package com.heven.excleToSQL;

public class StringToJson {

	public static void main(String[] args) {
		String[] s = {"2017年04月","2017年05月","2017年06月"};
		String[] s1 = {"2017年04月"};
		String string1 = "2017年6月2017年5月2017年7月2017年8月";
		String string2 = "2017年6月";
//		String res = stringToJson(st);
		String res = getDateToJson(string2);
		System.out.println(res);

	}
	
	public static String stringToJson(String[] s){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		//添加brnNo
		sb.append("brnNo:\"1\",");
		//添加时间
		addTime(s, sb);
		sb.append("}");
		return sb.toString();
	}

	private static void addTime(String[] s, StringBuilder sb) {
		//如果只有一次，则不需要中括号
			if(s.length!=1)
				sb.append("[");
			//for循环添加缴费日期内容
			for(int i=0;i<s.length;i++){
				String[] strings = s[i].toString().split("月")[0].split("年");
				sb.append("缴费日期："+"\""+strings[0]+strings[1]+"\"");
				if(i!=s.length-1){
					sb.append(",");
				}
			}
			if(s.length!=1)
				sb.append("]");
	}
	
	public static String getDateToJson(String s){
		StringBuilder sb = new StringBuilder();
		String[] splitByMonth = s.split("月");
		sb.append("{");
		//添加brnNo
		sb.append("brnNo:\"1\",");
		if(splitByMonth.length!=1)
			sb.append("[");
		//for循环添加缴费日期内容
		for(int i=0;i<splitByMonth.length;i++){
			String[] strings = splitByMonth[i].split("年");
			sb.append("缴费日期："+"\""+strings[0]+strings[1]+"\"");
			if(i!=splitByMonth.length-1){
				sb.append(",");
			}
		}
		if(splitByMonth.length>1)
			sb.append("]");
		sb.append("}");
		return sb.toString();
	}
}
