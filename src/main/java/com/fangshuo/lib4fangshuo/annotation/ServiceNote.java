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
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ServiceNote
{
	// 公共交易(不检查权限),LOGIN(签到用户都可以调用),CHECK(必须有权限), DISABLE(交易已经被禁止)
	public static enum AUTH{ PUBLIC, LOGIN, CHECK, DISABLE };
	
	// 接口描述
	String desc();

	// 取值范围
	AUTH auth() default AUTH.CHECK;
	
}
