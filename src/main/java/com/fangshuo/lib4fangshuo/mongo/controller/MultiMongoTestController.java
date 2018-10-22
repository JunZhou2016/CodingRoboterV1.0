package com.fangshuo.lib4fangshuo.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.lib4fangshuo.mongo.service.MultiMongoDBService;
/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: MultiMongoTestController.java
* @Description: 多数据源mongo测试类;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年10月17日 下午8:50:19
 */
@RestController
@RequestMapping("mul-mongo")
public class MultiMongoTestController {
	@Autowired
	MultiMongoDBService multiMongoDBService;
	
	@RequestMapping("mongoTest")
	public void mongoTest() {
		multiMongoDBService.TestSave();
	}
}
