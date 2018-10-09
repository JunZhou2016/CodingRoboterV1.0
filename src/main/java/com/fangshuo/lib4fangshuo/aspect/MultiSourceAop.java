package com.fangshuo.lib4fangshuo.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;

import com.fangshuo.lib4fangshuo.annotation.TargetDataSource;
import com.fangshuo.lib4fangshuo.datasource.DataSourceContextHolder;
import com.fangshuo.lib4fangshuo.datasource.properties.MuliDataSourceProperties;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: MultiSourceAop.java
 * @Description: 多数据源动态切换的AOP控制类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月8日 下午3:45:39
 */
@Aspect
public class MultiSourceAop implements Ordered {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 多数据源的属性;
	 */
	@Autowired
	private MuliDataSourceProperties muliDataSourceProperties;

	@Pointcut(value = "@annotation(com.fangshuo.lib4fangshuo.annotation.TargetDataSource)")
	private void cut() {

	}

	@Around("cut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {

		Signature signature = point.getSignature();
		MethodSignature methodSignature = null;
		if (!(signature instanceof MethodSignature)) {
			throw new IllegalArgumentException("该注解只能用于方法");
		}
		methodSignature = (MethodSignature) signature;

		Object target = point.getTarget();
		Method currentMethod = target.getClass().getMethod(methodSignature.getName(),
				methodSignature.getParameterTypes());

		TargetDataSource datasource = currentMethod.getAnnotation(TargetDataSource.class);
		if (datasource != null) {
			// 根据数据源的名称动态切换;
			DataSourceContextHolder.setDataSourceType(datasource.name());
			log.info("设置数据源为：" + datasource.name());
		} else {
			DataSourceContextHolder.setDataSourceType(muliDataSourceProperties.getDataSourceNames().get(0));
			log.info("设置数据源为：" + muliDataSourceProperties.getDataSourceNames().get(0));
		}

		try {
			// 继续执行目标方法;
			return point.proceed();
		} finally {
			log.debug("清空数据源信息！");
			DataSourceContextHolder.clearDataSourceType();
		}
	}

	/**
	 * aop的顺序要早于spring的事务
	 */
	@Override
	public int getOrder() {
		return 1;
	}

}
