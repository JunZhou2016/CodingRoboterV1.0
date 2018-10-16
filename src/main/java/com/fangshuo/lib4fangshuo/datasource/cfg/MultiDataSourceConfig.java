package com.fangshuo.lib4fangshuo.datasource.cfg;

import java.sql.SQLException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.fangshuo.lib4fangshuo.aspect.MultiSourceAop;
import com.fangshuo.lib4fangshuo.datasource.DynamicDataSource;
import com.fangshuo.lib4fangshuo.datasource.ds.DefaultDataSource;
import com.fangshuo.lib4fangshuo.datasource.ds.FirstDataSource;
import com.fangshuo.lib4fangshuo.datasource.properties.MultiDataSourceProperties;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: MultiDataSourceConfig.java
 * @Description: 多数据源配置类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月8日 下午3:48:45
 */
@Configuration
@EnableTransactionManagement(order = 2)
public class MultiDataSourceConfig {

	private Logger logger = LoggerFactory.getLogger(MultiDataSourceConfig.class);

	@Bean
	public MultiSourceAop multiSourceExAop() {
		return new MultiSourceAop();
	}

	/**
	 * 多数据源的属性;
	 */
	@Autowired
	@Qualifier("multiDataSourceProperties")
	private MultiDataSourceProperties multiDataSourceProperties;

	/**
	 * 多数据源连接池配置
	 */
	@Bean
	public DynamicDataSource multiDataSource() {

		// 数据源实例初始化;
		DefaultDataSource defaultDs = new DefaultDataSource();// 默认数据源;
		FirstDataSource firstDs = new FirstDataSource();// 自定义的数据源First;
		try {
			// 数据源初始化;
			defaultDs.init();
			firstDs.init();
		} catch (SQLException sql) {
			sql.printStackTrace();
		}

		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		HashMap<Object, Object> hashMap = new HashMap<>();
		// 将两个数据源加入map
		hashMap.put(multiDataSourceProperties.getDataSourceNames().get(0), defaultDs);
		hashMap.put(multiDataSourceProperties.getDataSourceNames().get(1), firstDs);

		logger.info("两个数据源名字分别为{},{}", multiDataSourceProperties.getDataSourceNames().get(0),
				multiDataSourceProperties.getDataSourceNames().get(1));
		// 设置目标数据源;
		dynamicDataSource.setTargetDataSources(hashMap);
		// 设置默认数据源;
		dynamicDataSource.setDefaultTargetDataSource(defaultDs);
		return dynamicDataSource;
	}

	/**
	 * 乐观锁mybatis插件
	 */
	@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
		return new OptimisticLockerInterceptor();
	}

	/**
	 * 事物配置;
	 * 
	 * @param mutiDataSource
	 * @return
	 */
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DynamicDataSource mutiDataSource) {
		return new DataSourceTransactionManager(mutiDataSource);
	}

}
