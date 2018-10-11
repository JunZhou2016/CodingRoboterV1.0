package com.fangshuo.lib4fangshuo.datasource.ds;

import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
import com.fangshuo.lib4fangshuo.utils.SpringUtils;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: DefaultDataSource.java
 * @Description: 默认数据源;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月8日 下午9:24:22
 */
public class DefaultDataSource extends DruidDataSource {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public DefaultDataSource() {
		Environment env = SpringUtils.getBean(Environment.class);
		/**
		 * 必要属性;
		 */
		this.setUrl(env.getProperty("spring.default.datasource.url"));
		this.setUsername(env.getProperty("spring.default.datasource.username"));// 用户名
		this.setPassword(env.getProperty("spring.default.datasource.password"));// 密码
		this.setDriverClassName(env.getProperty("spring.default.datasource.driver-class-name"));
		
		/**
		 * 优化属性;
		 */
		this.setInitialSize(Integer.parseInt(env.getProperty("spring.default.datasource.initial-size")));// 初始化时建立物理连接的个数
		this.setMaxActive(Integer.parseInt(env.getProperty("spring.default.datasource.max-active")));// 最大连接池数量
		this.setMinIdle(Integer.parseInt(env.getProperty("spring.default.datasource.min-idle")));// 最小连接池数量
		this.setMaxWait(Integer.parseInt(env.getProperty("spring.default.datasource.max-wait")));// 获取连接时最大等待时间，单位毫秒。
		this.setPoolPreparedStatements(
				Boolean.parseBoolean(env.getProperty("spring.default.datasource.pool-prepared-statements")));// 是否缓存preparedStatement，也就是PSCache
		this.setTestOnBorrow(false);// 申请连接时执行validationQuery检测连接是否有效
		this.setTestWhileIdle(true);// 建议配置为true，不影响性能，并且保证安全性。
		this.setValidationQuery("SELECT 1");// 用来检测连接是否有效的sql。
	}
}
