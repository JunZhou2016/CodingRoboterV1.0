package com.fangshuo.dbinfo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.dbinfo.Service.TabInfoService;
import com.fangshuo.dbinfo.model.Table;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: TabInfoController.java
* @Description: 数据库表信息的控制器类;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月25日 上午9:43:29
 */
@RestController
@RequestMapping("/tabinfo")
public class TabInfoController {
	@Autowired
	private TabInfoService tabInfoService;
	
	/**
	 * 根据条件查询数据数据库基础信息的集合;
	 * [一次查询多个数据库表的信息]
	 * @return:数据库基础信息的集合;
	 */
	@RequestMapping("/get_TabInfosByCondition")
	@ResponseBody
	public List<Table> getTabInfoSetByCondition() {
		List<String> tabNames = new ArrayList<String>();
		tabNames.add("role");
		tabNames.add("stu");
		//获取数据库表中的属性信息;
		List<Table> tabInfoSetList = tabInfoService.getTabInfoSetByCondition(tabNames);
		return tabInfoSetList;
	}
}
