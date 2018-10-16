package com.fangshuo.RobBooter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.codefactory.utils.CodeGeneratorUtils;
import com.fangshuo.codefactory.utils.Logger;
import com.fangshuo.dbinfo.Service.DbInfoService;
import com.fangshuo.dbinfo.model.database.Database;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
@RequestMapping("/codePrinter")
@Api(value = "代码生成控制器", tags = { "代码生成控制器的API" })
@RestController
public class RoboterBooter {

	@Autowired
	private DbInfoService dbInfoService;

	/**
	 * 根据条件查询数据数据库基础信息的集合; [一次查询多个数据库表的信息]
	 * 
	 * @return:数据库基础信息的集合;
	 */
	@RequestMapping(value = "/printCodeByTables", method = RequestMethod.POST)
	@ApiOperation("根据数据表名称生成代码")
	@ResponseBody
	public Database printCodeByTables(@RequestBody Database dbFilter, HttpServletRequest request,
			HttpServletResponse response) {
		CodeGeneratorUtils codeGeneratorUtils = new CodeGeneratorUtils();
		// 获取数据库表的实例;
		// List<String> tabNames = new ArrayList<String>();
		// tabNames.add("role");
		// 获取项目的基本信息;
		// List<Table> tableList = tabInfoService.getTabInfoByTableName(tabNames);
		Database dbInfo = dbInfoService.getDBInfosByCondition(dbFilter);
		// 代码生成;
		codeGeneratorUtils.generateCodeAndInitPageByDB(dbInfo);
		String requestHeader = request.getHeader("user-agent");
		Logger.info(requestHeader);

		return dbInfo;
	}

}
