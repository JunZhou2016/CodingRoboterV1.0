package com.fangshuo.dbinfo.model.database;
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

import java.util.ArrayList;
import java.util.List;

import com.fangshuo.dbinfo.utils.DBUtils;

public class Table {
	private String id;// 数据表中列的id;
	private String primaryKey;// 数据表的主键;
	private String tableName;// 数据表的名称;
	private String tableComment;// 数据表的注释;
	private String tabColString;// 数据表列信息的字符串形式;
	private List<Column> columnSet;// 数据表的列集合;
	private List<ERObject> erList = new ArrayList<ERObject>();// 实体属性和表格关系的list;

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
		//将table的数据列转化为指定格式的字符串;
		String tableStringTemp = DBUtils.tableToString(this);
		this.setTabColString(tableStringTemp);
		//从数据表的列名获取列和属性的集合;
		DBUtils.getErMapFromTableColumn(this.erList,this.tabColString);
		this.setErList(this.erList);
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getTabColString() {
		return tabColString;
	}

	public void setTabColString(String tabColString) {
		this.tabColString = tabColString;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public List<ERObject> getErList() {
		return erList;
	}

	public void setErList(List<ERObject> erList) {
		this.erList = erList;
	}
}
