package com.fangshuo.tempTest.reflexTest;

import java.util.List;

import com.fangshuo.lib4fangshuo.annotation.JobNote;
import com.fangshuo.lib4fangshuo.utils.AnnotationUtils;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ReflexTest.java
 * @Description: 反射测试类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 下午3:26:30
 */
@JobNote(name = "")
public class ReflexTest {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String packageName = "com.fangshuo.tempTest.reflexTest";
		List<String> requestMappingValue = AnnotationUtils.getRequestMappingValue(packageName);
		for (String string : requestMappingValue) {
			System.out.println("-------Ele------" + string);
		}
	}
}
