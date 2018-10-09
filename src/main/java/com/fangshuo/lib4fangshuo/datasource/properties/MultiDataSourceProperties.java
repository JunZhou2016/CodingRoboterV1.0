package com.fangshuo.lib4fangshuo.datasource.properties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: MultiDataSourceProperties.java
 * @Description: 多数据源属性实体类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月8日 下午5:22:06
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class MultiDataSourceProperties {
	/**
	 * 数据源名称的集合;
	 */
	private List<String> dataSourceNames = new ArrayList<String>(Arrays.asList("defaultDS", "firstDS"));
	
	public List<String> getDataSourceNames() {
		return dataSourceNames;
	}

	public void setDataSourceNames(List<String> dataSourceNames) {
		this.dataSourceNames = dataSourceNames;
	}
}
