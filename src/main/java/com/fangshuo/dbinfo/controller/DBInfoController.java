package com.fangshuo.dbinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.dbinfo.Service.DbInfoService;
import com.fangshuo.dbinfo.model.Database;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: DBInfoController.java
* @Description: 查询数据库基本信息的控制类;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月21日 下午4:11:28
 */
@RestController
@RequestMapping("/dbinfo")
public class DBInfoController {
	@Autowired
	private DbInfoService dbInfoService;
	
	/**
	 * 获取数据库属性信息;
	 * @return:String;
	 */
	@RequestMapping("/get-dbInfos")
	@ResponseBody
	public List<Database> getDbInfos() {
		List<Database> dbInfo = dbInfoService.getDbInfos();
		return dbInfo;
	}
}
