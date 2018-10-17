package com.fangshuo.lib4fangshuo.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fangshuo.lib4fangshuo.mongo.model.repository.primary.PrimaryMongoObject;
import com.fangshuo.lib4fangshuo.mongo.model.repository.primary.PrimaryRepository;
import com.fangshuo.lib4fangshuo.mongo.model.repository.secondary.SecondaryMongoObject;
import com.fangshuo.lib4fangshuo.mongo.model.repository.secondary.SecondaryRepository;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: MultiMongoDBTest.java
 * @Description: MongoDB多数据源测试类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月17日 下午4:39:04
 */
@Component
public class MultiMongoDBService {
	@Autowired
	private PrimaryRepository primaryRepository;

	@Autowired
	private SecondaryRepository secondaryRepository;

	public void TestSave() {

		System.out.println("************************************************************");
		System.out.println("测试开始");
		System.out.println("************************************************************");

		this.primaryRepository.save(new PrimaryMongoObject(null, "第1个库的对象"));

		this.secondaryRepository.save(new SecondaryMongoObject(null, "第2个库的对象"));

		List<PrimaryMongoObject> primaries = this.primaryRepository.findAll();
		for (PrimaryMongoObject primary : primaries) {
			System.out.println(primary.toString());
		}

		List<SecondaryMongoObject> secondaries = this.secondaryRepository.findAll();

		for (SecondaryMongoObject secondary : secondaries) {
			System.out.println(secondary.toString());
		}

		System.out.println("************************************************************");
		System.out.println("测试完成");
		System.out.println("************************************************************");
	}
}
