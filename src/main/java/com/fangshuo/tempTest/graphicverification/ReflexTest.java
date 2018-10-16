package com.fangshuo.tempTest.graphicverification;

import cn.hutool.core.swing.ClipboardUtil;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ReflexTest.java
 * @Description: 反射测试的工具类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月11日 上午9:10:36
 */
public class ReflexTest {
	public static void main(String[] args) {
		/*
		 * Person person = new Person(); ReflectUtil.invoke(person, "setSex", "WoMan");
		 * Object result = ReflectUtil.invoke(person, "getSex");
		 */
		/* String result = RuntimeUtil.execForStr("ipconfig -all"); */

		String result = ClipboardUtil.getStr();
		System.out.println("----------->>>" + result);

	}
}
