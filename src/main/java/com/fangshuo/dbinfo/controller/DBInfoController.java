package com.fangshuo.dbinfo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.dbinfo.Service.DbInfoService;
import com.fangshuo.dbinfo.model.database.Database;
import com.fangshuo.lib4fangshuo.exception.FsException;
import com.fangshuo.lib4fangshuo.exception.constant.ErrMsgConstant;
import com.fangshuo.lib4fangshuo.model.ReqObject;
import com.fangshuo.lib4fangshuo.model.ResObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
@RequestMapping("/dbinfo")
@Api(value="数据库信息控制器",tags = {"数据库信息管理API"})
@RestController
public class DBInfoController {
	@Autowired
	private DbInfoService dbInfoService;
	
	/**
	 * 根据条件获取数据库属性信息;
	 * @param dbFilter
	 * @return
	 */
	@ApiOperation("查询数据库基础信息")
	@RequestMapping(value="/get-dbInfosByCondition",method = RequestMethod.POST)
	@ResponseBody
	public ResObject<Database> getDBInfosByCondition(@RequestBody ReqObject<Database> dbFilter,
			HttpServletRequest request, HttpServletResponse response) {
		Database dbQueryCondition = dbFilter.getObject();
		Database executeResult = dbInfoService.getDBInfosByCondition(dbQueryCondition);
		ResObject<Database> reqObject = new ResObject<Database>(dbFilter,executeResult,request);
		return reqObject;
	}
	
	/**
	 * 根据条件获取数据库属性信息;
	 * @param dbFilter
	 * @return
	 */
	@ApiOperation("查询数据库基础信息")
	@RequestMapping(value="/get-testErrorCode",method = RequestMethod.POST)
	@ResponseBody
	public ResObject<Database> testErrorCode(HttpServletRequest request, HttpServletResponse response) {
		try {
			throwException();
			return new ResObject<Database>(request);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResObject<Database>(e,request);
		}
	}
	
	public static void throwException() {
		if(2>1) {
			throw new FsException(ErrMsgConstant.FILE_NOT_EXISTS_ERROR);
		}
	}
	
}
