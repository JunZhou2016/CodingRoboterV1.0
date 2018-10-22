package com.fangshuo.tempTest;

import com.fangshuo.codefactory.utils.Logger;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: StringTest.java
* @Description: 字符串测试工具类;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年10月18日 下午1:59:25
 */
public class StringTest {
	public static void main(String[] args) {
		String projectName = "generator-demo";
		String newProjectName = projectName.replace("-", "_");
		Logger.info(projectName);
		Logger.info(newProjectName);
	}
	
}
