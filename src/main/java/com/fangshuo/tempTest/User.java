package com.fangshuo.tempTest;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: User.java
 * @Description: 测试json用的用户实体类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月1日 下午8:52:22
 */
public class User {
	private String name = "JunZhou";
	private String age = null;

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getAge() {
		return age;
	}

	protected void setAge(String age) {
		this.age = age;
	}
}
