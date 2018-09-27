package com.fangshuo.lib4fangshuo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字段注释
 * @author skywoo
 *
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
