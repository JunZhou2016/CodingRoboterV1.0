package com.fangshuo.dbinfo.model;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: DBInfo.java
 * @Description: 数据库基础信息；
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月21日 下午3:50:52
 */
public class Database {
	private String id;// 数据表的id;
	private String tableName;// 数据表的名称;
	private String tableComment;// 数据表的注释;
	//数据表的集合@TODO;
	
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

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	@Override
	public String toString() {
		return "DBInfo [id=" + id + ", tableName=" + tableName + ", tableComment=" + tableComment + "]";
	}
}
