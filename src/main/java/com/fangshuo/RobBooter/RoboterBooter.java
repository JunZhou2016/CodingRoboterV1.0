package com.fangshuo.RobBooter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.codefactory.utils.CodeGeneratorUtils;
import com.fangshuo.dbinfo.Service.TabInfoService;
import com.fangshuo.dbinfo.model.Table;

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
@RestController
@RequestMapping("/codePrinter")
public class RoboterBooter {
	
	@Autowired
	private TabInfoService tabInfoService;
	/**
	 * 根据条件查询数据数据库基础信息的集合;
	 * [一次查询多个数据库表的信息]
	 * @return:数据库基础信息的集合;
	 */
	@RequestMapping("/printCodeByTables")
	@ResponseBody
	public List<Table> getTabInfoSetByCondition() {
		CodeGeneratorUtils codeGeneratorUtils = new CodeGeneratorUtils();
		//获取数据库表的实例;
		List<String> tabNames = new ArrayList<String>();
		//tabNames.add("role");
		List<Table> tableList = tabInfoService.getTabInfoSetByCondition(tabNames);
		//代码生成;
		codeGeneratorUtils.generateCodeByTable(tableList);
		
		return tableList;
	}
	
	
}
