package com.fangshuo.dbinfo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.dbinfo.Service.TabInfoService;
import com.fangshuo.dbinfo.model.database.Table;
import com.fangshuo.lib4fangshuo.model.ReqQuery;
import com.fangshuo.lib4fangshuo.model.ResList;
import com.fangshuo.lib4fangshuo.model.ResObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
@RequestMapping("/tabinfo")
@Api(value = "数据表信息控制器", tags = { "数据表信息管理API" })
@RestController
public class TabInfoController {
	@Autowired
	private TabInfoService tabInfoService;

	/**
	 * 根据条件查询数据数据库基础信息的集合; [一次查询多个数据库表的信息]
	 * 
	 * @param tabNameList：数据表名称的集合;
	 * @return:数据库基础信息的集合;
	 */
	@ApiOperation("根据数据表名称查询数据表的基础信息")
	@RequestMapping(value = "/get_TabInfoByTabName", method = RequestMethod.POST)
	@ResponseBody
	public ResObject<ResList<Table>> getTabInfoByTableName(@RequestBody ReqQuery<List<String>> qryFilter,
			HttpServletRequest request) {
		// 获取数据库表中的属性信息;
		try {
			ResList<Table> queryRes = tabInfoService.getTabInfoByTableName(qryFilter);
			ResObject<ResList<Table>> resObj = new ResObject<ResList<Table>>(qryFilter, queryRes, request);
			return resObj;
		} catch (Exception e) {
			// TODO: handle exception
			return new ResObject<ResList<Table>>(qryFilter, e, request);
		}
	}
}
