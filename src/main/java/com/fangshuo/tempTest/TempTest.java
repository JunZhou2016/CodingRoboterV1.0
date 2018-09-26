package com.fangshuo.tempTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fangshuo.codefactory.utils.Logger;
import com.fangshuo.dbinfo.model.Column;

public class TempTest {
	public static void main(String[] args) {
		// 项目在硬盘上的基础路径
	/* String PROJECT_PATH = System.getProperty("user.dir");
	 System.out.println("---------"+PROJECT_PATH+"-----------");*/
	 /*String modelNameUpperCamel = "wisdomPark";
	 String upStr = StringUtils.toUpperCaseFirstOne(modelNameUpperCamel);
	 System.out.println("############"+upStr+"############");*/
	 /*String categoryStr = "ServiceImpl";
	 String substring = categoryStr.substring(0, categoryStr.length()-5);
	 System.out.println(substring);*/
	
	 List<Column> columnList = new ArrayList<Column>();
	 Column column1 = new Column("role","id");
	 Column column2 = new Column("role","name");
	 Column column3 = new Column("role","age");
	 
	 columnList.add(column1);
	 columnList.add(column2);
	 columnList.add(column3);
	 
	 Logger.info(listToString(columnList));
	}
	
	public static String listToString(List<Column> columnList) {
		Iterator<Column> it = columnList.iterator();
		if (columnList.isEmpty()) {
		     return "Role[]";
		   }
		   StringBuilder buffer = new StringBuilder(16);
		   buffer.append("\"Role[\"");
		   while(it.hasNext()) {
			   Column columnEle = it.next();
			   buffer.append(columnEle.getColumnName()+"=" + columnEle.getColumnName() + ",");
		   }
		   int lastIndexOfComma = buffer.lastIndexOf(",");
		   String substring = buffer.substring(0, lastIndexOfComma);
		   substring = substring + "\"]\"";
		  /* Gson gson = new Gson();
		   String json = gson.toJson(columnList);*/
		return substring;
	}
}
