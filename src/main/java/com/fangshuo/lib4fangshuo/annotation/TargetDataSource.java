package com.fangshuo.lib4fangshuo.annotation;

import java.lang.annotation.*;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: TargetDataSource.java
* @Description: 多数据源标识注解;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年10月8日 下午3:42:14
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface TargetDataSource {
	
	/**
	 * 数据源的名称;
	 * @return
	 */
    String name() default "";


}
