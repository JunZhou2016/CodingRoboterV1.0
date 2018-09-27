package com.fangshuo.dbinfo.model;
/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: TabInfoSet.java
* @Description: 数据库表信息的展示实体；
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月25日 上午10:31:25
 */

import java.util.List;

import com.fangshuo.dbinfo.utils.DBUtils;

public class Table {
	private String id;// 数据表中列的id;
	private String tableName;// 数据表的名称;
	private String tableComment;// 数据表的注释;
	private List<Column> columnSet;// 数据表的列集合;
	private String tableString;//数据表的字符串形式;
	
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

	public List<Column> getColumnSet() {
		return columnSet;
	}

	public void setColumnSet(List<Column> columnSet) {
		this.columnSet = columnSet;
		String tableStringTemp = DBUtils.tableToString(this);
		this.setTableString(tableStringTemp);
	}

	public String getTableString() {
		return tableString;
	}

	public void setTableString(String tableString) {
		this.tableString = tableString;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}


	

}
