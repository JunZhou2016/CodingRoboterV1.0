package com.fangshuo.dbinfo.model;
/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: TabInfoSet.java
* @Description: 数据库表信息的集合；
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月25日 上午10:31:25
 */

import java.util.List;

public class TabInfoSet {
	private String id;// 数据表中列的id;
	private String tableName;// 数据表的名称;
	List<TabInfo> tabInfoItemSet;// 满足条件的数据库表的集合;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<TabInfo> getTabInfoItemSet() {
		return tabInfoItemSet;
	}

	public void setTabInfoItemSet(List<TabInfo> tabInfoItemSet) {
		this.tabInfoItemSet = tabInfoItemSet;
	}
}
