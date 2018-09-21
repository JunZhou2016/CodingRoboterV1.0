package com.fangshuo.dbinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.dbinfo.Service.StuService;
import com.fangshuo.dbinfo.model.User;

@RestController
public class StuController {
	@Autowired
	private StuService stuService;

	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		User stu = stuService.getById(20142213);
		return stu.getName();
	}
}
