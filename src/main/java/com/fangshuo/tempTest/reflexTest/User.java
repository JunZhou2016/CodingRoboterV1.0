package com.fangshuo.tempTest.reflexTest;

import com.fangshuo.lib4fangshuo.annotation.JobNote;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: User.java
 * @Description: 用户信息实体类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 下午3:25:16
 */
@JobNote(name="Person",bean="com.fangshuo.tempTest.reflexTest.Person")
public class User extends Person{
	private String name = "JunZhou";
	private int age = 23;

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected int getAge() {
		return age;
	}

	protected void setAge(int age) {
		this.age = age;
	}
}
