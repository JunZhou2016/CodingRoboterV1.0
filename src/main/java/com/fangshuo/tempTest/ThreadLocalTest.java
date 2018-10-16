package com.fangshuo.tempTest;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ThreadLocalTest.java
 * @Description: 本地线程资源测试;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月8日 下午1:16:12
 */
public class ThreadLocalTest {
	private static final ThreadLocal<String> RESOURCE = new ThreadLocal<String>();

	public static void main(String[] args) {
		RESOURCE.set("zhoujun");
	}
}
