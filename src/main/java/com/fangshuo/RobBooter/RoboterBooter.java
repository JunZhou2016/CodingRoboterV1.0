package com.fangshuo.RobBooter;

import com.fangshuo.codefactory.utils.CodeGeneratorUtils;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: RoboterBooter.java
* @Description: 代码生成器的启动入口;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月25日 下午5:31:56
 */
public class RoboterBooter {
	public static void main(String[] args) {
		CodeGeneratorUtils codeGeneratorUtils = new CodeGeneratorUtils();
		String modelName = "User";
		String codeType = "Controller";
		codeGeneratorUtils.genCode(modelName,codeType);
	}
}
