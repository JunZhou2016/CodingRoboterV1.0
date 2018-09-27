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
@Target(ElementType.TYPE)
public @interface PojoNote
{
	// 类描述
	String desc();
	
	// 资源名称，比如对应数据表名称
	String resource() default "";
}
