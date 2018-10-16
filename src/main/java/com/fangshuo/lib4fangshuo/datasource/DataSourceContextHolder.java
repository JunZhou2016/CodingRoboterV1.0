package com.fangshuo.lib4fangshuo.datasource;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: DataSourceContextHolder.java
 * @Description: 数据源上下文持有者，在当前线程内共享数据源信息;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月8日 下午3:44:27
 */
public class DataSourceContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/**
	 * 设置数据源类型
	 *
	 * @param dataSourceType 数据库类型
	 */
	public static void setDataSourceType(String dataSourceType) {
		contextHolder.set(dataSourceType);
	}

	/**
	 * 获取数据源类型
	 */
	public static String getDataSourceType() {
		return contextHolder.get();
	}

	/**
	 * 清除数据源类型
	 */
	public static void clearDataSourceType() {
		contextHolder.remove();
	}
}
