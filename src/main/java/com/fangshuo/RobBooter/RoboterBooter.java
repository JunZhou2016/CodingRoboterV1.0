package com.fangshuo.RobBooter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.codefactory.cfg.CodeGeneratorConfig;
import com.fangshuo.codefactory.utils.CodeGeneratorUtils;
import com.fangshuo.codefactory.utils.StringUtils;
import com.fangshuo.dbinfo.Service.DbInfoService;
import com.fangshuo.dbinfo.model.database.Database;
import com.fangshuo.lib4fangshuo.utils.FileUtil;
import com.google.gson.Gson;

import cn.hutool.core.util.ZipUtil;
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
public class RoboterBooter extends CodeGeneratorConfig {

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
		Database dbInfo = dbInfoService.getDBInfosByCondition(dbFilter);
		// 代码生成;
		codeGeneratorUtils.generateCodeAndInitPageByDB(dbInfo);
		return dbInfo;
	}

	/**
	 * 根据条件查询数据数据库基础信息的集合; [一次查询多个数据库表的信息]
	 * 
	 * @return:数据库基础信息的集合;
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "/fetchSourceCode", method = RequestMethod.POST)
	@ApiOperation("根据数据表名称生成代码并打包")
	@ResponseBody
	public void fetchSourceCode(@RequestBody Database dbFilter, HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException {
		CodeGeneratorUtils codeGeneratorUtils = new CodeGeneratorUtils();
		Database dbInfo = dbInfoService.getDBInfosByCondition(dbFilter);
		// 代码生成;
		codeGeneratorUtils.generateCodeAndInitPageByDB(dbInfo);
		// 项目代码处理;
		String finallyProjectName = dbInfo.getDbName();
		String targetPath = PROJECT_ZIP_PATH;
		String resultPath = PROJECT_ZIP_READ_PATH + "/" + finallyProjectName + ".zip";// 压缩文件的名称;
		String reallyTargetPath = StringUtils.getFilePathByWindowsPath(targetPath);// 特殊字符转义;
		String reallyResultPath = StringUtils.getFilePathByWindowsPath(resultPath);// 特殊字符转义;
		// 压缩生成的项目;
		ZipUtil.zip(reallyTargetPath, reallyResultPath, true);
		// 浏览器下载;
		String fileName = finallyProjectName+".zip";
		File file = new File(resultPath);
		InputStream is = new FileInputStream(file);
		FileUtil.downFileFromStream(fileName, is, request, response);

	}
	
	/**
	 * 根据条件查询数据数据库基础信息的集合; [一次查询多个数据库表的信息]
	 * 
	 * @return:数据库基础信息的集合;
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "/fetchSourceCodeByForm", method = RequestMethod.POST)
	@ApiOperation("根据数据表名称生成代码并打包")
	@ResponseBody
	public void fetchSourceCodeByForm(@RequestParam(value="params")String params, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
		Gson gson = new Gson();
		Database dbFilter = gson.fromJson(params, Database.class);
		CodeGeneratorUtils codeGeneratorUtils = new CodeGeneratorUtils();
		Database dbInfo = dbInfoService.getDBInfosByCondition(dbFilter);
		// 代码生成;
		codeGeneratorUtils.generateCodeAndInitPageByDB(dbInfo);
		// 项目代码处理;
		String finallyProjectName = dbInfo.getDbName();
		String targetPath = PROJECT_ZIP_PATH;
		String resultPath = PROJECT_ZIP_READ_PATH + "/" + finallyProjectName + ".zip";// 压缩文件的名称;
		String reallyTargetPath = StringUtils.getFilePathByWindowsPath(targetPath);// 特殊字符转义;
		String reallyResultPath = StringUtils.getFilePathByWindowsPath(resultPath);// 特殊字符转义;
		// 压缩生成的项目;
		ZipUtil.zip(reallyTargetPath, reallyResultPath, true);
		// 浏览器下载;
		String fileName = finallyProjectName+".zip";
		File file = new File(resultPath);
		InputStream is = new FileInputStream(file);
		FileUtil.downFileFromStream(fileName, is, request, response);

	}

}
