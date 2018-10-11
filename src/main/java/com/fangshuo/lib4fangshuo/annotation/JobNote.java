package com.fangshuo.lib4fangshuo.annotation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: JobNote.java
 * @Description: 定时任务详细信息描述的注解;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 下午3:42:59
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
public @interface JobNote{

	// Job描述
	String des() default "";// job描述;

	String cron() default "";// cron定时表达式;

	String name() default "";// job的名称;

	String group() default "";// job所属分组的名称;

	Map<String, Class<?>> clazzSet = new HashMap<String, Class<?>>();//Job对象的Class对象集合,该集合是静态的;
}
