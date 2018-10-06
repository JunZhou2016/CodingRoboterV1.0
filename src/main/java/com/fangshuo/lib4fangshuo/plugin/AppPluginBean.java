package com.fangshuo.lib4fangshuo.plugin;

import java.util.Properties;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: AppPluginCfg.java
 * @Description: 应用插件配置类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月30日 下午1:36:49
 */
public class AppPluginBean {
	@Autowired
	private Environment env;

	/**
	 * 连接池基础信息配置; destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
	 *
	 */
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));// 用户名
		dataSource.setPassword(env.getProperty("spring.datasource.password"));// 密码
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setInitialSize(2);// 初始化时建立物理连接的个数
		dataSource.setMaxActive(20);// 最大连接池数量
		dataSource.setMinIdle(0);// 最小连接池数量
		dataSource.setMaxWait(60000);// 获取连接时最大等待时间，单位毫秒。
		dataSource.setValidationQuery("SELECT 1");// 用来检测连接是否有效的sql。
		dataSource.setTestOnBorrow(false);// 申请连接时执行validationQuery检测连接是否有效
		dataSource.setTestWhileIdle(true);// 建议配置为true，不影响性能，并且保证安全性。
		dataSource.setPoolPreparedStatements(false);// 是否缓存preparedStatement，也就是PSCache
		return dataSource;
	}

	/**
	 * 
	 * 配置mybatis的分页插件pageHelper
	 */
	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("reasonable", "true");
		properties.setProperty("dialect", "mysql");// 配置mysql数据库的方言
		pageHelper.setProperties(properties);
		return pageHelper;
	}

	/**
	 * 七牛云存储的文件上传配置
	 * 
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 文件最大
		factory.setMaxFileSize("10240KB"); // KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("102400KB");
		return factory.createMultipartConfig();
	}
}
