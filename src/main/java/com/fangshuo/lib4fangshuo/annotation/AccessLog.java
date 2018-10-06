package com.fangshuo.lib4fangshuo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: AccessLog.java
 * @Description: 访问日志的注解;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月6日 下午8:21:45
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLog {
	/**
	 * 操作类型[增加，删除，修改，查找]
	 * 
	 * @return
	 */
	String type() default "";

	/**
	 * 操作名称;
	 * 
	 * @return
	 */
	String value() default "";
}
