package com.fangshuo.codefactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fangshuo.codefactory.model.ProjectInfo;
import com.fangshuo.codefactory.model.ResObj4CR;
import com.fangshuo.codefactory.service.CodeGeneratorService;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: CodeGeneratorController.java
 * @Description: 代码生成的控制器;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月25日 下午2:53:06
 */
public class CodeGeneratorController {

	@Autowired
	private CodeGeneratorService codeGeneratorService;

	/**
	 * 获取数据库属性信息;
	 * 
	 * @return:String;
	 */
	@RequestMapping("/get-dbInfos")
	@ResponseBody
	public ResObj4CR generateCode4You(ProjectInfo projectInfo) {
		ResObj4CR resObj4CR = codeGeneratorService.generateCode4You(projectInfo);
		return resObj4CR;
	}
}
