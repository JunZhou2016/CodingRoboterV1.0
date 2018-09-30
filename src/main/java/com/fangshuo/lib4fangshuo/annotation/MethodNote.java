package com.fangshuo.lib4fangshuo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: MethodNote.java
* @Description: 描述方法的注释;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月30日 上午9:09:28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodNote
{
	// 公共交易/开发测试(不检查权限),LOGIN(签到用户都可以调用),CHECK(必须有权限), DISABLE(交易已经被禁止)
	public static enum AUTH{ PUBLIC, LOGIN, CHECK, DISABLE };
	
	// 接口描述
	String desc();

	// 取值范围
	AUTH auth() default AUTH.CHECK;
	
}
