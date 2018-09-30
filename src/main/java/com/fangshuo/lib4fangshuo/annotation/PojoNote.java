package com.fangshuo.lib4fangshuo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 项目/Class的注释;
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: PojoNote.java
* @Description: 该类的功能描述
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月30日 上午9:07:55
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface PojoNote
{
	// 类描述
	String desc();
	
	// 应数据表名称
	String resource() default "";
}
