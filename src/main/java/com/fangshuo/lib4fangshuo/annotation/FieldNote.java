package com.fangshuo.lib4fangshuo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: FieldNote.java
* @Description: 字段注释;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月30日 上午9:07:28
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface FieldNote
{
	// 字段描述
	String desc();
		
	// 字段是否能够空
	boolean notNull() default false;

	// 数据类型和长度
	String dataTypeAndLen() default "";
	
	// 取值范围
	String valueSet() default "";
	
	// 校验函数
	String validator() default "";
}
