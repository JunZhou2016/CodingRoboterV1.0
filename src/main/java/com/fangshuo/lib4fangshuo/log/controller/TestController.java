package com.fangshuo.lib4fangshuo.log.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.lib4fangshuo.annotation.AccessLog;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: TestController.java
 * @Description: 日志模块集成测试的controller;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月7日 下午12:27:26
 */
@RestController
public class TestController {
	@AccessLog(type = "新增", value = "日志记录模块集成测试")
	@RequestMapping("/test")
	public String testLog() {
		return "test";
	}
}
