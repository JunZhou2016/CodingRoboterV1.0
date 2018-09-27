package com.fangshuo.lib4fangshuo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: ClazzNote.java
* @Description: 标记Class的注解;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月27日 下午3:21:17
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface ClazzNote
{
	// 类描述
	String desc();
	String version() default "V1.0.0";
	String creatorTime() default "000000";
	String creator() default "JunZhou";
	
	
	// 资源名称
	String resource() default "";

	// 模块名称
	String modName() default "";
	String modDesc() default "";
}
